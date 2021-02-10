/*
﻿Developed with the contribution of the European Commission - Directorate General for Maritime Affairs and Fisheries
© European Union, 2015-2016.

This file is part of the Integrated Fisheries Data Management (IFDM) Suite. The IFDM Suite is free software: you can
redistribute it and/or modify it under the terms of the GNU General Public License as published by the
Free Software Foundation, either version 3 of the License, or any later version. The IFDM Suite is distributed in
the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more details. You should have received a
copy of the GNU General Public License along with the IFDM Suite. If not, see <http://www.gnu.org/licenses/>.
 */
package eu.europa.ec.fisheries.uvms.audit.mapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import eu.europa.ec.fisheries.schema.audit.v1.AuditLogType;
import eu.europa.ec.fisheries.uvms.audit.MockData;
import eu.europa.ec.fisheries.uvms.audit.dao.exception.AuditDaoException;
import eu.europa.ec.fisheries.uvms.audit.dao.exception.AuditDaoMappingException;
import eu.europa.ec.fisheries.uvms.audit.entity.component.AuditLog;
import eu.europa.ec.fisheries.uvms.audit.util.DateUtil;

@RunWith(MockitoJUnitRunner.class)
public class MapperTest {

    @InjectMocks
    private MapperBean mapper;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testEntityToModel() throws AuditDaoException, AuditDaoMappingException {
        long id = 1;
        AuditLog entity = MockData.getEntity(id);
        AuditLogType result = mapper.toModel(entity);

        assertSame(entity.getAffectedObject(), result.getAffectedObject());
        assertSame(entity.getObjectType(), result.getObjectType());
        assertSame(entity.getOperation(), result.getOperation());
        assertSame(entity.getUsername(), result.getUsername());
        assertEquals(entity.getTimestamp(), result.getTimestamp());
    }

    @Test
    public void testModelToEntity() throws AuditDaoException, AuditDaoMappingException {
        Integer id = 1;
        AuditLogType model = MockData.getModel(id);
        AuditLog result = mapper.toEntity(model);

        assertSame(model.getAffectedObject(), result.getAffectedObject());
        assertSame(model.getObjectType(), result.getObjectType());
        assertSame(model.getOperation(), result.getOperation());
        assertSame(model.getUsername(), result.getUsername());
    }

}