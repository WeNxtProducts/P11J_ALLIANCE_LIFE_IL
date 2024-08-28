package com.iii.pel.forms.PILM040;

import com.iii.apps.persistence.ConnectionManager;
import com.iii.apps.persistence.PremiaCryptograph;

public class encryDecry {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		String driver_class = PremiaCryptograph.encrypt(ConnectionManager.ENCRYPTION_KEY, "jdbc:oracle:thin:@192.168.10.7:1521:ORCL");
//		String driver_url = PremiaCryptograph.encrypt(ConnectionManager.ENCRYPTION_KEY, "oracle:thin:@192.168.10.2:1521:ORAUAT");
		String user_name = PremiaCryptograph.encrypt(ConnectionManager.ENCRYPTION_KEY, "P11_AIC_DEV");
		String user_pwd = PremiaCryptograph.encrypt(ConnectionManager.ENCRYPTION_KEY, "P11_AIC_DEV");
		

		//192.168.10.7:1521:ORCL      P11_AIC_DEV/P11_AIC_DEV
		String driver_class1 = PremiaCryptograph.decrypt(ConnectionManager.ENCRYPTION_KEY, "3226321432063198321931973151320532183211319931593202322132063227319932173147319532293195321432083210316732253201322332003232");
		String driver_url1 = PremiaCryptograph.decrypt(ConnectionManager.ENCRYPTION_KEY, "32213200320731983169320732193196321732213201317132183211320632193156316731503164316131503167314631573145316031533157315731673166315031623160318631833176317431523150");
		String user_name1 = PremiaCryptograph.decrypt(ConnectionManager.ENCRYPTION_KEY, "3194318231823178318931913154314831923208316831823188");
		String user_pwd1 = PremiaCryptograph.decrypt(ConnectionManager.ENCRYPTION_KEY, "3194318231823178318931913154314831923208316831823188");
		// Added for cryptography in property file ]
		System.out.println("-------------Connection1--------");
		System.out.println("driver_url : " + driver_class);
		System.out.println("driver_url1 : " + user_name);
		System.out.println("user_pwd : " + user_pwd);
//		System.out.println("user_pwd : " + user_pwd1);
		
		
	}

}
