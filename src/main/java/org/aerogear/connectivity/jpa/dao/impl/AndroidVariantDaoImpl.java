/**
 * JBoss, Home of Professional Open Source
 * Copyright Red Hat, Inc., and individual contributors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.aerogear.connectivity.jpa.dao.impl;

import java.util.List;

import org.aerogear.connectivity.jpa.AbstractGenericDao;
import org.aerogear.connectivity.jpa.dao.AndroidVariantDao;
import org.aerogear.connectivity.model.AndroidVariant;

public class AndroidVariantDaoImpl extends AbstractGenericDao<AndroidVariant, String> implements AndroidVariantDao {

    @SuppressWarnings("unchecked")
    @Override
    public List<AndroidVariant> findAll() {
        return createQuery("select t from "+AndroidVariant.class.getSimpleName()+" t").getResultList();   
    }

    @Override
    public AndroidVariant findByVariantID(String variantID) {
        return (AndroidVariant) createQuery("select t from "+AndroidVariant.class.getSimpleName()+" t where t.variantID = :variantID")
                .setParameter("variantID", variantID)
                .getSingleResult();
    }
}