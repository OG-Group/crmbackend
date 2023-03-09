package com.argroupcrm.crm.service.cian;

import com.argroupcrm.crm.controller.advice.SaveException;
import com.argroupcrm.crm.generic.crud.service.AbstractServiceImpl;
import com.argroupcrm.crm.model.auth.UserEntity;
import com.argroupcrm.crm.model.cian.BuildingCianEntity;
import com.argroupcrm.crm.repository.cian.BuildingCianRepository;
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
public class BCianServiceImpl extends AbstractServiceImpl<BuildingCianEntity, BuildingCianRepository> {
    private final BuildingCianRepository buildingCianRepository;
    private final UserService userService;
    private final ModelMapper patchingMapper;
    private final XmlCreator feed;

    public BCianServiceImpl(BuildingCianRepository repository, UserService userService,
                            ModelMapper patchingMapper, XmlCreator feed) {
        super(repository);
        this.buildingCianRepository = repository;
        this.userService = userService;
        this.patchingMapper = patchingMapper;
        this.feed = feed;
    }

    @Override
    @Transactional
    public BuildingCianEntity save(BuildingCianEntity entityReq) {
        try {
            BuildingCianEntity entity = buildingCianRepository.save(entityReq);
            if (entity.getServiceInformationSaveOnCian()) {
                if (entity.getCategoryBuilding().toLowerCase().contains("buildingrent")) {

                    UserEntity user = userService.getCurrent();

                    Integer countAvailablePremium = user.getPremiumCianCount();

                    feed.CianRentBuildingXML(entity, countAvailablePremium);
                } else if (entity.getCategoryBuilding().toLowerCase().contains("buildingsale")) {
                    UserEntity user = userService.getCurrent();

                    Integer countAvailablePremium = user.getPremiumCianCount();

                    feed.CianSaleBuildingXML(entity, countAvailablePremium);
                }
            }
            return entity;
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
