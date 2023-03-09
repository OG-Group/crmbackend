package com.argroupcrm.crm.generic.crud.model.specification.request;

import com.argroupcrm.crm.controller.advice.FilterFieldTypeException;
import com.argroupcrm.crm.generic.crud.model.specification.enums.FieldType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.InvalidDataAccessApiUsageException;

import java.io.Serial;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author ogbozoyan
 * @date 01.03.2023
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Slf4j
/*
  This is a main request that be used from REST API.
 */
public class SearchRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = 8514625832019794838L;

    private List<FilterRequest> filters;

    private List<SortRequest> sorts;

    private Integer page;

    private Integer size;

    public List<FilterRequest> getFilters() {
        if (Objects.isNull(this.filters)) return new ArrayList<>();
        return this.filters;
    }

    public List<SortRequest> getSorts() {
        if (Objects.isNull(this.sorts)) return new ArrayList<>();
        return this.sorts;
    }

    /**
     * FieldType validator can handle when FieldType empty and incorrect type:
     */
    public SearchRequest validateFilterType(Class<?> classFields, SearchRequest requestFilters) {

        List<FilterRequest> newFilters = new ArrayList<>();

        try {
            for (Field field : classFields.getDeclaredFields()) {
                for (FilterRequest filter : requestFilters.getFilters()) {
                    if (filter.getKey().equals("id")) {
                        filter.setFieldType(FieldType.LONG);
                        newFilters.add(filter);
                    } else if (field.getName().equals(filter.getKey())) {
                        String fName = field.getType().getCanonicalName();
                        switch (fName) {
                            case "java.lang.Boolean" -> {
                                filter.setFieldType(FieldType.BOOLEAN);
                                newFilters.add(filter);
                            }
                            case "java.lang.Character" -> {
                                filter.setFieldType(FieldType.CHAR);
                                newFilters.add(filter);
                            }
                            case "java.sql.Timestamp" -> {
                                filter.setFieldType(FieldType.DATE);
                                newFilters.add(filter);
                            }
                            case "java.lang.Double" -> {
                                filter.setFieldType(FieldType.DOUBLE);
                                newFilters.add(filter);
                            }
                            case "java.lang.Integer" -> {
                                filter.setFieldType(FieldType.INTEGER);
                                newFilters.add(filter);
                            }
                            case "java.lang.Long" -> {
                                filter.setFieldType(FieldType.LONG);
                                newFilters.add(filter);
                            }
                            case "java.lang.String" -> {
                                filter.setFieldType(FieldType.STRING);
                                newFilters.add(filter);
                            }
                            default -> {
                                filter.setFieldType(FieldType.OBJECT);
                                newFilters.add(filter);
                            }
                        }
                    }
                }
            }
            requestFilters.setFilters(newFilters);
        } catch (InvalidDataAccessApiUsageException e) {
            e.printStackTrace();
            throw new FilterFieldTypeException("Wrong FilterField type");
        } catch (Exception e) {
            e.printStackTrace();
            throw new FilterFieldTypeException("FilterField validator exception");
        }
        return requestFilters;
    }
    /*
      Request examples:
      =======================Without Filter and Sorting============================================
      {
          "filters": [],
          "sorts": [],
          "page": null,
          "size": null
      }
      =======================Filter by Name and Sort by Release Date ASC===========================
      Filter name equal to filterName
      {
          "filters": [
              {
                  "key": "name",
                  "operator": "EQUAL",
                  "field_type": "STRING",
                  "value": "filterName"
              }
          ],
          "sorts": [
              {
                  "key": "releaseDate",
                  "direction": "ASC"
              }
          ],
          "page": null,
          "size": null
      }
      =======================Filter name not equal to filterName===================================
       {
          "filters": [
              {
                  "key": "name",
                  "operator": "NOT_EQUAL",
                  "field_type": "STRING",
                  "value": "filterName"
              }
          ],
          "sorts": [
              {
                  "key": "releaseDate",
                  "direction": "ASC"
              }
          ],
          "page": null,
          "size": null
      }
      =======================Filter name not equal to filterName and size 1 response================
      {
          "filters": [
              {
                  "key": "name",
                  "operator": "NOT_EQUAL",
                  "field_type": "STRING",
                  "value": "filterName"
              }
          ],
          "sorts": [
              {
                  "key": "releaseDate",
                  "direction": "ASC"
              }
          ],
          "page": null,
          "size": 1
      }
      =======================Filter name like and sort by release data DESC================
      {
          "filters": [
              {
                  "key": "name",
                  "operator": "LIKE",
                  "field_type": "STRING",
                  "value": "Red"
              }
          ],
          "sorts": [
              {
                  "key": "releaseDate",
                  "direction": "DESC"
              }
          ],
          "page": null,
          "size": null
      }
      =======================Filter kernel in===============================================
      {
          "filters": [
              {
                  "key": "kernel",
                  "operator": "IN",
                  "field_type": "STRING",
                  "values": ["5.13", "5.8"]
              }
          ],
          "sorts": [],
          "page": null,
          "size": null
      }
      =======================Filter using between===============================================
      Filter release date
      {
          "filters": [
              {
                  "key": "releaseDate",
                  "operator": "BETWEEN",
                  "field_type": "DATE",
                  "value": "01-03-2022 00:00:00",
                  "value_to": "11-03-2022 23:59:59"
              }
          ],
          "sorts": [],
          "page": null,
          "size": null
      }
      Or
       {
          "filters": [
              {
                  "key": "usages",
                  "operator": "BETWEEN",
                  "field_type": "INTEGER",
                  "value": 100,
                  "value_to": 250
              }
          ],
          "sorts": [],
          "page": null,
          "size": null
      }
     */
}