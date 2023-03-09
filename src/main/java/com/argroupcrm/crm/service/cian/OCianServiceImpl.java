package com.argroupcrm.crm.service.cian;

import com.argroupcrm.crm.controller.advice.SaveException;
import com.argroupcrm.crm.generic.crud.service.AbstractServiceImpl;
import com.argroupcrm.crm.model.auth.UserEntity;
import com.argroupcrm.crm.model.cian.OfficeCianEntity;
import com.argroupcrm.crm.repository.cian.OfficeCianRepository;
import com.argroupcrm.crm.service.auth.UserService;
import com.argroupcrm.crm.util.XmlCreator;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceException;

@Service
@Slf4j
public class OCianServiceImpl extends AbstractServiceImpl<OfficeCianEntity, OfficeCianRepository> {
    private final OfficeCianRepository officeCianRepository;
    private final UserService userService;
    private final ModelMapper patchingMapper;
    private final XmlCreator feed;

    public OCianServiceImpl(OfficeCianRepository repository, OfficeCianRepository officeCianRepository,
                            UserService userService, ModelMapper patchingMapper, XmlCreator feed) {
        super(repository);
        this.officeCianRepository = officeCianRepository;
        this.userService = userService;
        this.patchingMapper = patchingMapper;
        this.feed = feed;
    }

    @Override
    @Transactional
    public OfficeCianEntity save(OfficeCianEntity entityReq) {
        try {
            OfficeCianEntity entity = officeCianRepository.save(entityReq);
            if (entity.getServiceInformationSaveOnCian()) {
                if (entity.getCategoryOffice().toLowerCase().contains("officerent")) {

                    UserEntity user = userService.getCurrent();

                    Integer countAvailablePremium = user.getPremiumCianCount();

                    feed.CianRentOfficeXML(entity, countAvailablePremium);
                } else if (entity.getCategoryOffice().toLowerCase().contains("officesale")) {
                    UserEntity user = userService.getCurrent();

                    Integer countAvailablePremium = user.getPremiumCianCount();

                    feed.CianSaleOfficeXML(entity, countAvailablePremium);
                }
            }
            return officeCianRepository.save(entity);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            throw new IllegalArgumentException();
        } catch (OptimisticLockingFailureException e) {
            e.printStackTrace();
            throw new OptimisticLockingFailureException("OptimisticLockingFailureException exception on save: " + entityReq);
        } catch (DataIntegrityViolationException e) {
            e.printStackTrace();
            throw new DataIntegrityViolationException("DataIntegrityViolationException exception on save: " + entityReq);
        } catch (TransactionSystemException e) {
            e.printStackTrace();
            throw new TransactionSystemException("TransactionSystemException exception on save: " + entityReq);
        } catch (JpaSystemException e) {
            e.printStackTrace();
            throw new JpaSystemException(e);
        } catch (PersistenceException e) {
            e.printStackTrace();
            throw new PersistenceException("PersistenceException exception on save: " + entityReq);
        } catch (Exception e) {
            e.printStackTrace();
            throw new SaveException("Can't save entity: " + entityReq);
        }
    }
}
