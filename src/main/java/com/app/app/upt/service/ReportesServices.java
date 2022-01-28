/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.app.upt.service;

import com.app.app.upt.dto.ReportesDTO;
import java.util.List;

/**
 *
 * @author Alejandro
 */
public interface ReportesServices {
    
    List<ReportesDTO> listReports();
    Boolean addReport (ReportesDTO reportes);
    Boolean editReport (String id, ReportesDTO reportes);
    Boolean deleteReport(String id);
    
}
