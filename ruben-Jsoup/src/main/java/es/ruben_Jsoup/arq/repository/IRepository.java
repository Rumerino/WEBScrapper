/*******************************************************************************
 * Copyright (c) 2017, - All Rights Reserved Unauthorized copying of this file,
 * via any medium is strictly prohibited Proprietary and confidential
 *
 * Contributors: <a href="mailto:ruben.merino@altia.es">Rubén Merino</a>
 *******************************************************************************/
package es.ruben_Jsoup.arq.repository;

import java.io.Serializable;
import java.sql.Connection;

import es.ruben_Jsoup.arq.model.es.ruben_Jsoup.arq.model.IModel;

/**
 * TODO JAVADOC IRepository
 *
 * @version 1.0.0
 * @author ruben.merino (ver. 1.0.0)
 * @param <T>
 * @param <K>
 */
public interface IRepository<T extends IModel<K>, K extends Serializable> {

    /**
     * Inserta un nuevo registro
     *
     * @param con Conexión al repositorio
     * @param entity Concepto a insertar
     * @return Concepto insertado (con su PK rellena)
     * @throws RepositoryException Si se producen errores durante la operación
     */
    T insert(Connection con, T entity) throws RepositoryException;

    /**
     * Persiste un registro
     *
     * @param con Conexión al repositorio
     * @param entity Concepto a persistir
     * @return Concepto persistido
     * @throws RepositoryException Si se producen errores durante la operación
     */

}
