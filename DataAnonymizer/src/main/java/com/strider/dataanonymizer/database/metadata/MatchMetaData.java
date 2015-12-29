/*
 * 
 * Copyright 2014, Armenak Grigoryan, and individual contributors as indicated
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 */

package com.strider.dataanonymizer.database.metadata;

import java.util.Comparator;
import java.util.List;

/**
 * Data object to hold all metadata for matching data in Discovery applications.
 * Currently this object holds column and table metadata; ie, duplicating info.  
 * But since the numbers of tables/columns will always be
 * limited in size, don't really see an immediate need to refactor this.
 * @author Armenak Grigoryan
 */
public class MatchMetaData {
    private final String schemaName;
    private final String tableName;
    private final List<String> pkeys;
    private final String columnName;
    private final String columnType;
    private double averageProbability = 0;   
    private String model = "";

    public MatchMetaData(final String schemaName, final String tableName, final List<String> pkeys,
        final String columnName, final String columnType) {
        this.schemaName = schemaName;
        this.tableName  = tableName;
        this.pkeys = pkeys;
        this.columnName = columnName;
        this.columnType = columnType;
    }   

    public String getSchemaName() {
        return this.schemaName;
    }
    
    public String getTableName() {
        return this.tableName;
    }
    
    public List<String> getPkeys() {
        return pkeys;
    }

    public String getColumnName() {
        return this.columnName;
    }

    public String getColumnType() {
        return this.columnType;
    }    
    
    public void setAverageProbability(double averageProbability) {
        this.averageProbability = averageProbability;
    }
    
    public double getAverageProbability() {
        return this.averageProbability;
    }
    
    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }        
    
    @Override
    public String toString() {
        return this.tableName + "." + this.columnName;
    }
    
    public String toVerboseStr() {
        return this.schemaName + "." + toString() + "(" + this.columnType + ")";
    }
    
    /**
     * @return comparator used for sorting
     */
    public static Comparator<MatchMetaData> compare() {
            return Comparator.comparing(MatchMetaData::getSchemaName)
                              .thenComparing(MatchMetaData::getTableName)
                              .thenComparing(MatchMetaData::getColumnName);            
    }
}

