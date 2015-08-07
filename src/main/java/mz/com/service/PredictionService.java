/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mz.com.service;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.drools.core.event.DebugRuleRuntimeEventListener;
import org.kie.api.KieServices;
import org.kie.api.event.rule.DebugAgendaEventListener;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 *
 * @author Lenovo
 */
public class PredictionService {

    public enum RESULT {

        PASS, FAIL
    }

    private KieSession ksession;

    public PredictionService() throws Exception {

        // KieServices is the factory for all KIE services 
        KieServices ks = KieServices.Factory.get();

        // From the kie services, a container is created from the classpath
        KieContainer kc = ks.getKieClasspathContainer();

        // From the container, a session is created based on  
        // its definition and configuration in the META-INF/kmodule.xml file 
        ksession = kc.newKieSession("BasicRuleKS");

        // The application can also setup listeners
        ksession.addEventListener(new DebugAgendaEventListener());
        ksession.addEventListener(new DebugRuleRuntimeEventListener());

    }

    public RESULT executePrediction(String nAssgment, String nQuiz) {

        Test test = new Test(nAssgment, nQuiz);

        ksession.insert(test);

        // and fire the rules
        ksession.fireAllRules();

        // Remove comment if using logging
        // logger.close();
        // and then dispose the session
        ksession.dispose();

        if (nAssgment.equals("high")) {
            return RESULT.PASS;
        } else {

            if (nQuiz.equals("low")) {
                return RESULT.FAIL;
            } else {
                return RESULT.PASS;
            }
        }

    }

    public void test(String nAssgment, String nQuiz) {

        Test test = new Test(nAssgment, nQuiz);

        ksession.insert(test);

        // and fire the rules
        ksession.fireAllRules();

        // Remove comment if using logging
        // logger.close();
        // and then dispose the session
        ksession.dispose();
    }

    public static void main(String[] args) {
        
        try {
            PredictionService p = new PredictionService();
            
            p.test("high", "low");
            
            
        } catch (Exception ex) {
            Logger.getLogger(PredictionService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
