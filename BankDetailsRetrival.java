package org.wavessolutions.co.ke;

import com.thomas_bayer.blz.BLZService;
import com.thomas_bayer.blz.BLZServicePortType;
import com.thomas_bayer.blz.DetailsType;

public class BankDetailsRetrival {

	public static void main(String[] args) {
		LogError le = new LogError();
		try{
		if(args.length !=1){
			System.out.println("Please provide a bank code!!!");
		}else{
			String bankcode = args[0];
			BLZService bl = new BLZService();
			BLZServicePortType bptyp = bl.getBLZServiceSOAP11PortHttp();
			DetailsType dt = bptyp.getBank(bankcode);
			//log this details to log files
			le.Log_Error("BankDetailsRetrival", new Exception(dt.getBezeichnung()));
			System.out.println(dt.getBezeichnung());
			System.out.println(dt.getBic());
			System.out.println(dt.getOrt());
			System.out.println(dt.getPlz());
		}
		}catch(Exception ex){
			//log the error to log file
			le.Log_Error("BankDetailsRetrival", ex);
		}
	}
}
