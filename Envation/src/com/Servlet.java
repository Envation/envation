package com;

import java.io.IOException;
import java.lang.Math;
import java.math.BigDecimal;

//import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/result")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			System.out.println("Servlet Dzia�a");
			//loading variables given by user
			Double m_ST = Double.parseDouble(req.getParameter("m_ST"));
			Double t_ST = Double.parseDouble(req.getParameter("t_ST"))+273.16;
			Double p_ST = Double.parseDouble(req.getParameter("p_ST"))*1000000; //changing units to Pa
			Double t_FW = Double.parseDouble(req.getParameter("t_FW"))+273.16;
			Double p_FW = Double.parseDouble(req.getParameter("p_FW"))*1000000; //changing units to Pa
			Double m_SS = Double.parseDouble(req.getParameter("m_SS"));
			Double t_SS = Double.parseDouble(req.getParameter("t_SS"))+273.16;
			Double p_SS = Double.parseDouble(req.getParameter("p_SS"))*1000000; //changing units to Pa
			Double m_RHI1 = Double.parseDouble(req.getParameter("m_RHI1"));
			Double t_RHI1 = Double.parseDouble(req.getParameter("t_RHI1"))+273.16;
			Double p_RHI1 = Double.parseDouble(req.getParameter("p_RHI1"))*1000000; //changing units to Pa
			Double t_RHI2 = Double.parseDouble(req.getParameter("t_RHI2"))+273.16;
			Double p_RHI2 = Double.parseDouble(req.getParameter("p_RHI2"))*1000000; //changing units to Pa
			Double m_RHII1 = Double.parseDouble(req.getParameter("m_RHII1"));
			Double t_RHII1 = Double.parseDouble(req.getParameter("t_RHII1"))+273.16;
			Double p_RHII1 = Double.parseDouble(req.getParameter("p_RHII1"))*1000000; //changing units to Pa	
			Double t_RHII2 = Double.parseDouble(req.getParameter("t_RHII2"))+273.16;
			Double p_RHII2 = Double.parseDouble(req.getParameter("p_RHII2"))*1000000; //changing units to Pa
			Double m_SRI = Double.parseDouble(req.getParameter("m_SRI"));
			Double t_SRI = Double.parseDouble(req.getParameter("t_SRI"))+273.16;
			Double p_SRI = Double.parseDouble(req.getParameter("p_SRI"))*1000000; //changing units to Pa
			Double m_BD = Double.parseDouble(req.getParameter("m_BD"));
			Double t_BD = Double.parseDouble(req.getParameter("t_BD"))+273.16;
			Double p_BD = Double.parseDouble(req.getParameter("p_BD"))*1000000; //changing units to Pa
			Double m_SA = Double.parseDouble(req.getParameter("m_SA"));
			Double t_SA = Double.parseDouble(req.getParameter("t_SA"))+273.16;
			Double p_SA = Double.parseDouble(req.getParameter("p_SA"))*1000000; //changing units to Pa
			Double t_r = Double.parseDouble(req.getParameter("t_r"))+273.16;
			Double t_G = Double.parseDouble(req.getParameter("t_G"))+273.16;
			Double t_A = Double.parseDouble(req.getParameter("t_A"))+273.16;
			Double t_F = Double.parseDouble(req.getParameter("t_F"))+273.16;
			Double P_M = Double.parseDouble(req.getParameter("P_M"));
			Double P_UG = Double.parseDouble(req.getParameter("P_UG"));
			Double P = Double.parseDouble(req.getParameter("P"));
			Double P_U = Double.parseDouble(req.getParameter("P_U"));
			Double x_H2OAd = Double.parseDouble(req.getParameter("x_H2OAd"));
			Double y_O2d = Double.parseDouble(req.getParameter("y_O2d"));
			Double y_COd = Double.parseDouble(req.getParameter("y_COd"));
			Double t_SL = Double.parseDouble(req.getParameter("t_SL"))+273.16;
			Double n_SL = Double.parseDouble(req.getParameter("n_SL"));
			Double u_SL = Double.parseDouble(req.getParameter("u_SL"));
			Double u_FA = Double.parseDouble(req.getParameter("u_FA"));
			Double v = Double.parseDouble(req.getParameter("v"));
			Double Q_N = Usf_Heat_Out.result(m_ST,t_ST,p_ST,t_FW,p_FW,m_SS,t_SS,p_SS,m_RHI1,t_RHI1,p_RHI1,t_RHI2,
					p_RHI2,m_RHII1,t_RHII1,p_RHII1,t_RHII2,p_RHII2,m_SRI,t_SRI,p_SRI,m_BD,t_BD,p_BD,m_SA,t_SA,p_SA);
			String result = String.valueOf(Q_N);
			
			
			
			//Wsp�czynniki z normy
			
			Double L_r=2442.5;
			Double C_pSt=1.884;
			Double C_Fdaf=1.03;
			Double C_pA=1.011;
			Double C_pW=4.21;
			Double H_COn=(double) 12633;
			Double C_SLd=(double) 1;
			Double C_SLs=1.26;
			Double C_FA=0.84;
			Double H_uu_k=(double) 33000;
			Double H_uu_b=(double) 27200;
			Double q_nCO2=1.977;
			Double q_nAd=1.293;
			Double y_O2Ad=0.20938;
			Double x_CO2Ad=0.000505;
			Double y_CO2Ad=0.00033;
			
			//Wybory
			Double C_SL;
			Double H_uu;
			if (1>0)
			{
				C_SL= C_SLd;
			}
			else
			{
				C_SL = C_SLs;
			}
			if (1<0)
			{
				H_uu = H_uu_k;
			}
			else
			{
				H_uu = H_uu_b;
			}
			
			//Wsp�czynniki wielomian�w
			
			Double C_pAd0a = 1.004173;
			Double C_pAd0b = 1.91921E-05;
			Double C_pAd0c = 5.88348E-07;
			Double C_pAd0d = -7.01118E-10;
			Double C_pAd0e = 3.30953E-13;
			Double C_pAd0f = -5.67387E-17;
			
			Double P_1ma = 0.8554535;
			Double P_1mb = 0.000203601;
			Double P_1mc = 4.58308E-07;
			Double P_1md = -2.79808E-10;
			Double P_1me = 5.63441E-14;
			
			Double P_2ma = -0.1002311;
			Double P_2mb = 0.0007662;
			Double P_2mc = -9.26E-07;
			Double P_2md = 5.293E-10;
			Double P_2me = -1.094E-13;
			
			//Paliwo
			
			Double H_N = 8569.0;
			Double y_H2O = 0.517;
			Double y_Vm = 0.205;
			Double y_C = 0.2595;
			Double y_H = 0.0204;
			Double y_S = 0.0116;
			Double y_O = 0.0721;
			Double y_N = 0.0024;
			Double y_Ash = 0.117;
			Double H_G = H_N + y_H2O * L_r; // (8.3-67)
			
			//(8.3.4.2.1)
			
			Double u_Aod = (11.5122*y_C) + (34.2974*y_H) + (4.3129*y_S) - (4.3212*y_O); //(8.3-58)
			Double u_God = (11.5122*y_C) + (26.360*y_H) + (5.3129*y_S) - (3.3212*y_O) + y_N; //(8.3_59)
			Double V_God = (8.893*y_C) + (20.9724*y_H) + (3.3190*y_S) - (2.6424*y_O) + (0.7997*y_N); //(8.3_60)
			Double u_CO2o = (3.6699*y_C) + (0.0173*y_H) + (0.0022*y_S) - (0.0022*y_O); //(8.3_61)
			Double u_H2OF = (8.9370*y_H) + y_H2O; //(8.3_62)
			
			//(8.3.4.1)
			
			Double V_CO2o = u_CO2o / q_nCO2; //(8.3-45)
			Double y_CO2d = V_CO2o / V_God; //(8.3-46)
			Double u_Ad = u_Aod + q_nAd * V_God * y_O2d / (y_O2Ad - y_O2d); //(8.3-47)
			Double V_Gd = V_God * y_O2Ad / (y_O2Ad - y_O2d); //(8.3-48)
			Double u_CO2 = u_CO2o + q_nAd * V_God * y_O2d / (y_O2Ad - y_O2d) * x_CO2Ad; //(8.3-49)
			Double u_H2O = u_H2OF + u_Ad * x_H2OAd; // + u_AS; //(8.3-50) //??u_AS
			Double u_A = u_Ad * (1 + x_H2OAd); //(8.3-51)
			Double u_G = u_A + 1 - y_Ash * (1-v); //+ u_AS; //(8.3-52) //??u_AS 
			Double u_Gd = u_G - u_H2O; //&(8.3.2.2)
			Double x_CO2 = u_CO2 / u_G; //(8.3-53)
			Double x_H2O = u_H2O / u_G; //(8.3-54)
			
			//(8.3.4.4)
			
			Double C_pAd0tr = C_pAd0a + C_pAd0b /2*t_r + C_pAd0c /3*Math.pow(t_r , 2) + C_pAd0d /4*Math.pow(t_r , 3) + C_pAd0e /5*Math.pow(t_r , 4) + C_pAd0f /6*Math.pow(t_r , 5); //(8.3-77)
			Double P_1mtr = P_1ma + P_1mb / 2 * t_r + P_1mc / 3 * Math.pow(t_r , 2) + P_1md / 4 *Math.pow(t_r , 3) + P_1me/5 *Math.pow(t_r , 4); //(8.3-78)
			Double P_2mtr = P_2ma + P_2mb / 2 * t_r + P_2mc / 3 * Math.pow(t_r , 2) + P_2md / 4 *Math.pow(t_r , 3) + P_2me/5 *Math.pow(t_r , 4); //(8.3-79)
			Double C_pAd0tG = C_pAd0a + C_pAd0b /2*t_G + C_pAd0c /3*Math.pow(t_r , 2) + C_pAd0d /4*Math.pow(t_r , 3) + C_pAd0e /5*Math.pow(t_r , 4) + C_pAd0f /6*Math.pow(t_r , 5); //(8.3-77)
			Double P_1mtG = P_1ma + P_1mb / 2 * t_G + P_1mc / 3 * Math.pow(t_r , 2) + P_1md / 4 *Math.pow(t_r , 3) + P_1me/5 *Math.pow(t_r , 4); //(8.3-78)
			Double P_2mtG = P_2ma + P_2mb / 2 * t_G + P_2mc / 3 * Math.pow(t_r , 2) + P_2md / 4 *Math.pow(t_r , 3) + P_2me/5 *Math.pow(t_r , 4); //(8.3-79)
			Double C_pG = ((C_pAd0tr+(P_1mtr*x_H2O)+(P_2mtr*x_CO2))*t_r-(C_pAd0tG+(P_1mtG*x_H2O)+(P_2mtG*x_CO2))*t_G)/(t_r-t_G); //(8.3_80)
			Double C_pGd = ((C_pAd0tr+P_2mtr*x_CO2)*t_r-(C_pAd0tG+P_2mtG*x_CO2)*t_G)/(t_r-t_G); //(8.3_80)

			//(8.3.2)
			
			Double C_Fdaff = C_Fdaf*(1+0.2595); //Ciep�o w�a�ciwe Paliwa
			Double C_F = C_Fdaff*(1-y_H2O-y_Ash)+y_H2O*C_SL+y_Ash*C_FA;
			Double h_F = C_F*(t_F-t_r); //(8.3-12) N??
			Double n_FA = 1-n_SL; //(8.3-38)
			Double I_u = (y_Ash*(1-v)/(1-y_Ash-y_H2O))*((u_SL/(1-u_SL)*n_SL)+(u_FA/(1-u_FA)*n_FA)); //(8.3-37)
			Double J_NA = u_A*C_pA*(t_A-t_r); //(8.3-13N)
			Double J_GA = u_Ad*( C_pAd0tr *(t_A-t_r))+x_H2OAd*(L_r*(t_A-t_r)); //(8.3-13G) //Inaczej ni� w normie
			Double H_Ntot = (H_N + h_F)/(1-I_u)+J_NA; //(8.3-11N)
			Double H_Gtot = (H_G + h_F)/(1-I_u)+J_GA; //(8.3-11G)
			Double Q_NZ = P_M + P_UG + P; //(8.3-17N)
			Double Q_GZ = P_M + P_UG + P + P_U; //(8.3-17G)
			Double n_r = 1.0001;
			Double n_NB , Q_GZF , Q_GZtot , h_H2OG , h_H2Or , Q_GG, h_FA , Q_Gtot , Q_NZF;
			Double m_F;
			Double Q_Ntot;
			Double Q_NZtot;
			Double Q_NG;
			Double Q_CO;
			Double Q_SF;
			Double Q_RC;
			Double J_SF;
			Double h_SL;
			do
			{
			n_r = n_r - 0.0001;
			m_F = (Q_N/n_r-Q_NZ)/H_Ntot;
			Q_NZF = m_F*H_Ntot; //(8.3-11N)
			Q_GZF = m_F*H_Gtot; //(8.3-11G)
			Q_NZtot = Q_NZF + Q_NZ; //(8.3-19N)
			Q_GZtot = Q_GZF + Q_GZ; //(8.3-19N)
			
			//(8.3.3)
			
			Q_NG = m_F*u_G* C_pG *(t_G-t_r); //(8.3-20N)
			h_H2OG = Enthalpy.result(t_G, 100); 
			h_H2Or = Enthalpy.result(t_r, 100);
			Q_GG = m_F*(u_Gd*C_pGd*(t_G-t_r)+u_H2O*(h_H2OG-h_H2Or)); //(8.3-20G)
			Q_CO = m_F*V_Gd*y_COd*H_COn; //(8.3-22)
			
			h_SL = C_SL*(t_SL - t_r) + u_SL * H_uu;
			h_FA = C_FA * (t_G - t_r) + u_FA * H_uu;
			J_SF = ((y_Ash *(1-v)) / (1-I_u))*((n_SL/(1-u_SL))*h_SL + (n_FA / (1-u_FA)) * h_FA);
			Q_SF = m_F*J_SF;
			if (1>0)
			{
				Q_RC = 0.0315*Math.pow(Q_N/1000 , 0.7)*1000;
			}
			else
			{
				Q_RC = 0.022*Math.pow(Q_N/1000 , 0.7)*1000;
			}
			Q_Ntot = Q_NG + Q_CO + Q_SF + Q_RC;
			Q_Gtot = Q_GG + Q_CO + Q_SF + Q_RC;
			
			//(8.4)
			
			n_NB = 1 - Q_Ntot/Q_NZtot;
			//System.out.println("Iteracja"+n_NB +"  "+ n_r);
			}
			while (n_NB<n_r);
			System.out.println("Cieplo wlasciwe C_pG:"+C_pG);
			System.out.println("Cieplo wlasciwe C_pAd0tr:"+C_pAd0tr);
			req.setAttribute("Q_N", new BigDecimal(result).setScale(3, BigDecimal.ROUND_HALF_UP));
			req.setAttribute("n_NB",new BigDecimal(n_NB*100).setScale(2, BigDecimal.ROUND_HALF_UP));
			req.setAttribute("n_r",new BigDecimal(n_r*100).setScale(2, BigDecimal.ROUND_HALF_UP));
			req.setAttribute("m_F", new BigDecimal(m_F).setScale(3, BigDecimal.ROUND_HALF_UP));
			req.setAttribute("Q_Ntot", new BigDecimal(Q_Ntot).setScale(3, BigDecimal.ROUND_HALF_UP));
			req.setAttribute("Q_NZtot", new BigDecimal(Q_NZtot).setScale(3, BigDecimal.ROUND_HALF_UP));
			req.setAttribute("Q_NG", new BigDecimal(Q_NG).setScale(3, BigDecimal.ROUND_HALF_UP));
			req.setAttribute("Q_CO", new BigDecimal(Q_CO).setScale(3, BigDecimal.ROUND_HALF_UP));
			req.setAttribute("Q_SF", new BigDecimal(Q_SF).setScale(3, BigDecimal.ROUND_HALF_UP));
			req.setAttribute("Q_RC", new BigDecimal(Q_RC).setScale(3, BigDecimal.ROUND_HALF_UP));
			req.setAttribute("J_SF", new BigDecimal(J_SF).setScale(3, BigDecimal.ROUND_HALF_UP));
			req.setAttribute("I_u", new BigDecimal(I_u).setScale(6, BigDecimal.ROUND_HALF_UP));
			req.setAttribute("h_SL", new BigDecimal(h_SL).setScale(3, BigDecimal.ROUND_HALF_UP));
			req.setAttribute("H_Ntot", new BigDecimal(H_Ntot).setScale(3, BigDecimal.ROUND_HALF_UP));
						
			RequestDispatcher rd = req.getRequestDispatcher("/wynik.jsp");
			rd.forward(req,res);
			}	     
		}