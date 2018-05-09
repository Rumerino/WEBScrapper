/*******************************************************************************
 * Copyright (c) 2017, - All Rights Reserved Unauthorized copying of this file,
 * via any medium is strictly prohibited Proprietary and confidential
 *
 * Contributors: <a href="mailto:ruben.merino@altia.es">Rubén Merino</a>
 *******************************************************************************/
package es.ruben_Jsoup.arq.model.es.ruben_Jsoup.arq.model;

import java.io.Serializable;

/**
 * TODO JAVADOC IModel
 *
 * @version 1.0.0
 * @author ruben.merino (ver. 1.0.0)
 * @param <K>
 */
public interface IModel<K extends Serializable> extends Serializable {

    /**
     * Recupera la PK del concepto
     *
     * @return PK del concepto
     */
    K getPk();

    /**
     * Establece la PK del concepto
     *
     * @param pk PK del concepto
     */
    void setPK(K pk);

}
