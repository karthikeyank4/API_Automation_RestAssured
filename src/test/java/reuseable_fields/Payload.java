package reuseable_fields;

public class Payload {
	 
	//1 .embroidery Post Method.
	public static String embroideryPayload()
    {
 	   String embroideryName = "embroidery" +  Reusablefields.randomAlphabetic(5);
 	   String remarks ="remarks" +Reusablefields.randomAlphabetic(5);
 	   
 	   
 	   return" {\r\n"
 	   		+ "  \"embroideryName\": \""+embroideryName +"\",\r\n"
 	   		+ "  \"remarks\": \""+remarks+"\",\r\n"
 	   		+ "  \"screenId\": 1982,\r\n"
 	   		+ "  \"salesEnquiryMainId\": 541\r\n"
 	   		+ "}";
 	     }
	 // 2. digitalPrint Post Method.

	public static String digitalPrintPayload()
	
	{
		
		 String digitalPrintName = "Digital" + Authentication_Manual.randomAlphabetic(5); 
		 String remarks = "Remark" + Authentication_Manual.randomAlphabetic(4);
		
		return "{\r\n"
				+ "  \"salesEnquiryMainId\": 4078,\r\n"
				+ "  \"digitalPrintName\": \""+digitalPrintName+ "  \",\r\n"
				+ "  \"remarks\": \"" +remarks+"\",\r\n"
				+ "  \"screenId\": 9771\r\n"
				+ "}";
	}
	
	//3. atmType  Post Method.
	public static String atmTypePayload()
	{
		String atmtypename ="atmtypename"+ Reusablefields.randomAlphabetic(5) ;
		String remarks ="remarks"+Reusablefields.randomAlphabetic(5) ;
		
		return"{\r\n"
				+ "  \"atmTypeName\": \""+atmtypename+"\",\r\n"
				+ "  \"remarks\": \""+remarks+"\",\r\n"
				+ "  \"screenId\": 93,\r\n"
				+ "  \"salesEnquiryMainId\": 1791\r\n"
				+ "}";
	}
	
	//4.String BusinessType Post Method.
	
	public static String BusinessType()
	{
		
		String businessTypeName ="business" + Reusablefields.randomAlphabetic(5);
		
		
		
		return"{\r\n"
				+ "  \"businessTypeName\": \""+businessTypeName+"\",\r\n"
				+ "  \"screenId\": 6886\r\n"
				+ "}";
		}
	
	// 5. CampaignType Post Method.
	
	public static String campaignType()
	{
		String  name ="name " +Reusablefields.randomAlphabetic(5);
		String  type ="type" + Reusablefields.randomAlphabetic(5);
		return"{\r\n"
				+ "  \"campaignName\": \""+name+"\",\r\n"
				+ "  \"campaignType\": \""+type+"\",\r\n"
				+ "  \"description\": \"string\",\r\n"
				+ "  \"startDate\": \"2002-09-26T23:09:10.260Z\",\r\n"
				+ "  \"endDate\": \"2024-12-05T18:07:56.501Z\",\r\n"
				+ "  \"ownerId\": 4037,\r\n"
				+ "  \"isActive\": true,\r\n"
				+ "  \"screenId\": 3942\r\n"
				+ "}";
			}
	
	//6.ClothType Post Method 
	public static String clothType()
	{
		String clothname = "cloth" + Reusablefields.randomAlphabetic(5);
		String remarks = "remarks" +Reusablefields.randomAlphabetic(4);
		return"{\r\n"
				+ "  \"clothTypeName\": \""+clothname+"\",\r\n"
				+ "  \"remarks\": \""+remarks+"\",\r\n"
				+ "  \"screenId\": 98,\r\n"
				+ "  \"salesEnquiryMainId\": 5283\r\n"
				+ "}";
		
		
	}
	      //7. DeliveryOption Post Method
	public static String deliveryOption()
	{
		String name  ="name"+ Reusablefields.randomAlphabetic(5);
		String remarks ="remarks" + Reusablefields.randomAlphabetic(4);
		return "{\r\n"
				+ "  \"salesEnquiryId\": 3334,\r\n"
				+ "  \"deliveryOptionName\": \""+name+"\",\r\n"
				+ "  \"remarks\": \""+remarks+"\",\r\n"
				+ "  \"screenId\": 6121\r\n"
				+ "}";
		
	}
	 
	//8. FacilityType Post Method 
	
	public static String facilityType()
	{
		String name = "name"+ Reusablefields.randomAlphabetic(5);
		
		return"{\r\n"
				+ "  \"optionName\": \""+name+"\",\r\n"
				+ "  \"description\": \"string\",\r\n"
				+ "  \"screenId\": 812,\r\n"
				+ "  \"salesEnquiryMainId\": 8698\r\n"
				+ "}";
		
	}
	
	//9. IilumationType Post Method 
	
	public static String iiumationType()
	{
		String illuminationTypename ="name"+Reusablefields.randomAlphabetic(5);
		
		
		return "{\r\n"
				+ "  \"illuminationTypeName\": \""+illuminationTypename+"\",\r\n"
				+ "  \"salesEnquiryMainId\": 1435706626,\r\n"
				+ "  \"screenId\": 461242708,\r\n"
				+ "  \"remarks\": \"iXVEIqj\"\r\n"
				+ "}";
		
	}

	//10.Installation Equipment Post Method .
	
	public static String installationEquipment()
	{
		String name ="name"+ Reusablefields.randomAlphabetic(5);
		String remarks ="remarks"+Reusablefields.randomAlphabetic(4);
		
		return"{\r\n"
				+ "  \"equipmentName\": \""+name+"\",\r\n"
				+ "  \"heightInstallation\": 5786.046120487487,\r\n"
				+ "  \"remarks\": \""+remarks+"\",\r\n"
				+ "  \"screenId\": 5073,\r\n"
				+ "  \"salesEnquiryMainId\": 6125\r\n"
				+ "}";
		
	}
	//11. Invoice Refrence Post Method .
	
	public static String invoiceRefrence()
	{
		String name= "name"+Reusablefields.randomAlphabetic(5);
		
		return"{\r\n"
				+ "  \"invoiceType\": \""+name+"\",\r\n"
				+ "  \"invoiceId\": 3010,\r\n"
				+ "  \"invoiceDate\": \"2009-04-08T19:38:41.574Z\",\r\n"
				+ "  \"amount\": 3833.0234049465894,\r\n"
				+ "  \"screenId\": 5824\r\n"
				+ "}";
	}
	
	
	//12. ItemwiseTarget Post Method .
	
	public static String itemWiseTarget () 
	{
		return"{\r\n"
				+ "  \"salesmanEmpId\": 7881,\r\n"
				+ "  \"itemGroupId\": 4570,\r\n"
				+ "  \"targetStartDate\": \"1949-06-29T19:35:30.496Z\",\r\n"
				+ "  \"targetEndDate\": \"1996-11-13T17:27:47.714Z\",\r\n"
				+ "  \"financialYear\": 1855,\r\n"
				+ "  \"financialMonth\": 12,\r\n"
				+ "  \"targetQuantity\": 5055.223809216698,\r\n"
				+ "  \"targetAmount\": 8237.163997551987,\r\n"
				+ "  \"currencyId\": 1403,\r\n"
				+ "  \"screenId\": 7333\r\n"
				+ "}";
		
	}
	
	//13. Lamination Type Post Method .
	 public static String LaminationType()
	 {
		 String  laminationtpe =" type" +Reusablefields.randomAlphabetic(5);
		 String remarks ="remarks"+Reusablefields.randomAlphabetic(5);
		 
		 return "{\r\n"
		 		+ "  \"laminationTypeName\": \""+laminationtpe+"\",\r\n"
		 		+ "  \"remarks\": \""+remarks+"\",\r\n"
		 		+ "  \"screenId\": 3011,\r\n"
		 		+ "  \"salesEnquiryMainId\": 8660\r\n"
		 		+ "}";	 
	 }
	 //14. Material Category Post Method .
	 public static String materialCategory()
	 {
		 String categoryname ="categoryname" + Reusablefields.randomAlphabetic(5);
		 String description ="description" +Reusablefields.randomAlphabetic(4);
		 
		 return"{\r\n"
		 		+ "  \"salesEnquiryMainId\": 1600,\r\n"
		 		+ "  \"categoryName\": \""+categoryname+"\",\r\n"
		 		+ "  \"categoryDescription\": \""+description+"\",\r\n"
		 		+ "  \"materialId\": 6393,\r\n"
		 		+ "  \"isActive\": false,\r\n"
		 		+ "  \"screenId\": 7068\r\n"
		 		+ "";
	 }
	 //15. Material Grade Post Method .
	 public static String materialGrade()
	 {
		 String materialgradename ="materialgrade" + Reusablefields.randomAlphabetic(5);
		 String remarks ="remarks" +Reusablefields.randomAlphabetic(4);
		 
		 return"{\r\n"
		 		+ "  \"salesEnquiryMainId\": 7459,\r\n"
		 		+ "  \"materialGradeName\": \""+materialgradename+"\",\r\n"
		 		+ "  \"remarks\": \""+remarks+"\",\r\n"
		 		+ "  \"screenId\": 3843\r\n"
		 		+ "}";
	 }
	//16. Material Specification  Post Method .
	 public static String materialSpecification()
	 {
		 String  previousCostingEstimationNumber ="Costignumber" + Reusablefields.randomAlphabetic(5);
		 String lpoNumber  ="ipono" +Reusablefields.randomAlphabetic(4);
		 String competitor = "competitor"+Reusablefields.randomAlphabetic(5);
		 String specificInfoRemarks = "reamarks"+Reusablefields.randomAlphabetic(4);
		 
		 return"{\r\n"
		 		+ "  \"salesEnquiryMainId\": 6092,\r\n"
		 		+ "  \"materialId\": 5898,\r\n"
		 		+ "  \"previousCostingEstimationNumber\": \""+previousCostingEstimationNumber+"\",\r\n"
		 		+ "  \"quotationId\": 1366,\r\n"
		 		+ "  \"lpoNumber\": \""+lpoNumber+"\",\r\n"
		 		+ "  \"competitor\": \""+competitor+"\",\r\n"
		 		+ "  \"specificInfoRemarks\": \""+specificInfoRemarks+"\",\r\n"
		 		+ "  \"screenId\": 973,\r\n"
		 		+ "  \"createdBy\": 974,\r\n"
		 		+ "  \"createdAt\": \"1960-10-20T02:43:51.098Z\",\r\n"
		 		+ "  \"updatedBy\": 4884,\r\n"
		 		+ "  \"updatedAt\": \"1968-05-21T19:26:45.092Z\"\r\n"
		 		+ "}";
		 
		  }
	//17. Material Thickness  Post Method .
	 
	 public static String materialThickness()
	 {
		 
		 return"{\r\n"
		 		+ "  \"screenId\": 4534,\r\n"
		 		+ "  \"salesEnquiryMainId\": 9612,\r\n"
		 		+ "  \"materialThickness\": {\r\n"
		 		+ "    \"materialId\": 4761,\r\n"
		 		+ "    \"thicknessValue\": 7847.2453398547805,\r\n"
		 		+ "    \"uomId\": 1884\r\n"
		 		+ "  }\r\n"
		 		+ "}";
	 }
	 
	  //18.Material Type  Post Method .
	public static String materialType()
	{
		
		String materialtype ="material" + Reusablefields.randomAlphabetic(5);
		String remarks ="remarks"+ Reusablefields.randomAlphabetic(5);
		return "{\r\n"
				+ "  \"salesEnquiryMainId\": 4214,\r\n"
				+ "  \"materialType\": \""+materialtype +"\",\r\n"
				+ "  \"remarks\": \""+remarks+"\",\r\n"
				+ "  \"materialCategory\": 2215,\r\n"
				+ "  \"materialId\": 4018,\r\n"
				+ "  \"isDelete\": true,\r\n"
				+ "  \"isActive\": true,\r\n"
				+ "  \"screenId\": 4467,\r\n"
				+ "  \"createdBy\": 7836,\r\n"
				+ "  \"createdAt\": \"1973-05-12T11:35:54.371Z\",\r\n"
				+ "  \"updatedBy\": 1168,\r\n"
				+ "  \"updatedAt\": \"1955-09-06T22:46:33.132Z\"\r\n"
				+ "}";	
		
	}
	//19. Materials Post Method .
	
	public static String materials()
	{
		String materialname ="materialname" +Reusablefields.randomAlphabetic(5);
		String remarks ="remarks" +Reusablefields.randomAlphabetic(4);
		return" {\r\n"
				+ "  \"materialName\": \""+materialname+"\",\r\n"
				+ "  \"remarks\": \""+remarks+"\",\r\n"
				+ "  \"materialCategory\": 5846,\r\n"
				+ "  \"salesEnquiryMainId\": 3264,\r\n"
				+ "  \"screenId\": 6012\r\n"
				+ "}";
			}
	
	//20. MediaType Post Method .
	public static String mediaType()
	{
		String mediaTypeName ="media"+Reusablefields.randomAlphabetic(5);
		String remarks ="remarks"+Reusablefields.randomAlphabetic(4);
		
		return"{\r\n"
				+ "  \"materialId\": 1560265133,\r\n"
				+ "  \"mediaTypeName\": \""+mediaTypeName+" \",\r\n"
				+ "  \"remarks\": \""+remarks+"\",\r\n"
				+ "  \"salesEnquiryMainId\": 1343187,\r\n"
				+ "  \"screenId\": 2080172957\r\n"
				+ "}";
		
	}
	
	//21. PackagingType Post Method .
	
	public static String packagingType() 
	{
		String packagingTypename ="packaging"+Reusablefields.randomAlphabetic(5);
		String remarks ="remarks"+Reusablefields.randomAlphabetic(4);
		
		return"{\r\n"
				+ "  \"packagingTypeName\": \""+packagingTypename+"\",\r\n"
				+ "  \"remarks\": \""+remarks+"\",\r\n"
				+ "  \"salesEnquiryMainId\": 8464,\r\n"
				+ "  \"screenId\": 6874\r\n"
				+ "}";
		
		
	}
	
	//22. PaintfinishType Post Method .
	public static String paintfinishType()
	{
		String paintFinishTypeName ="paintfinish"+Reusablefields.randomAlphabetic(5);
		String remarks ="remarks"+Reusablefields.randomAlphabetic(4);
		return"{\r\n"
				+ "  \"paintFinishTypeName\": \""+paintFinishTypeName+"\",\r\n"
				+ "  \"remarks\": \""+remarks+"\",\r\n"
				+ "  \"screenId\": 4061,\r\n"
				+ "  \"salesEnquiryMainId\": 1127\r\n"
				+ "}";
		
		
	}
	
	//23. PalletType Post Method .
	public static String palletType()
	{
		String palletTypeName ="pallet"+Reusablefields.randomAlphabetic(5);
		String remarks ="remarks"+Reusablefields.randomAlphabetic(4);
		
		return"{\r\n"
				+ "  \"salesEnquiryMainId\": 6345,\r\n"
				+ "  \"palletTypeName\": \""+palletTypeName+"\",\r\n"
				+ "  \"remarks\": \""+remarks+"\",\r\n"
				+ "  \"isActive\": true,\r\n"
				+ "  \"screenId\": 1461\r\n"
				+ "}";
	}
	//24.PaymentTerms Post Method .
	
	public static String paymentTerms()
	{
		String paymentTermName ="paymentterm"+Reusablefields.randomAlphabetic(5);
		String remarks ="remarks"+Reusablefields.randomAlphabetic(4);
		
		return"{\r\n"
				+ "  \"paymentTermsName\": \""+paymentTermName+"\",\r\n"
				+ "  \"remarks\": \""+remarks+"\",\r\n"
				+ "  \"validFrom\": \"1958-08-28T21:28:59.086Z\",\r\n"
				+ "  \"screenId\": 6260\r\n"
				+ "}";
	}
	
	//25.PermitRequirement Post Method .
	public static String permitRequirement()
	{
		String permitRequirementName ="permit"+Reusablefields.randomAlphabetic(5);
		String remarks ="remarks"+Reusablefields.randomAlphabetic(4);
		return"{\r\n"
				+ "  \"permitRequirementName\": \""+permitRequirementName+" \",\r\n"
				+ "  \"remarks\": \""+remarks+"\",\r\n"
				+ "  \"screenId\": 210,\r\n"
				+ "  \"salesEnquiryMainId\": 6257\r\n"
				+ "}";
		
		
		
	}
	
	      //26.PowerAvailability Post Method .
	public static String powerAvailability()
	{
		String powerAvailabilityTypeName ="power"+Reusablefields.randomAlphabetic(5);
		String remarks ="remarks"+Reusablefields.randomAlphabetic(4);
	   return"{\r\n"
	   		+ "  \"powerAvailabilityTypeName\": \""+powerAvailabilityTypeName+"\",\r\n"
	   		+ "  \"salesEnquiryMainId\": 837935286,\r\n"
	   		+ "  \"screenId\": 1654324346,\r\n"
	   		+ "  \"isGeneratorRequired\": false,\r\n"
	   		+ "  \"remarks\": \""+ remarks+"\"\r\n"
	   		+ "}";
	   	}
	 
	//27. Product Type Post Method 
	
	public static String productType()
	{
		String productTypeName ="product"+ Reusablefields.randomAlphabetic(5);
		String remarks ="remarks"+ Reusablefields.randomAlphabetic(5);
		return"{\r\n"
				+ "  \"salesEnquiryMainId\": 8630,\r\n"
				+ "  \"productTypeName\": \""+productTypeName+"\",\r\n"
				+ "  \"remarks\": \""+remarks+"\",\r\n"
				+ "  \"isDelete\": false,\r\n"
				+ "  \"isActive\": false,\r\n"
				+ "  \"screenId\": 8291\r\n"
				+ "}";		
	}
	
	//28.ReflectiveOption 
	public static String ReflectiveOption()
	{
		String  reflectiveOptionName ="reflective"+Reusablefields.randomAlphabetic(5);
		String remarks ="remarks"+Reusablefields.randomAlphabetic(4);
		return"{\r\n"
				+ "  \"reflectiveOptionName\": \""+reflectiveOptionName+"\",\r\n"
				+ "  \"remarks\": \""+remarks+"\",\r\n"
				+ "  \"screenId\": 1962,\r\n"
				+ "  \"salesEnquiryMainId\": 6209\r\n"
				+ "}";
				
	}
	
	public static String sampleCategory()
	{
		String  categoryname ="category"+Reusablefields.randomAlphabetic(5);
		String description ="description"+Reusablefields.randomAlphabetic(5);
		return"{\r\n"
				+ "  \"categoryName\": \""+categoryname+"\",\r\n"
				+ "  \"description\": \""+description+""
				+ "  \"sampleMainId\": 301873009,\r\n"
				+ "  \"screenId\": 1239735472\r\n"
				+ "}";		
	}
	
	public static String sampleLocation()
	{
		String location ="location"+Reusablefields.randomAlphabetic(5);
		String remarks =	"remarks"+	Reusablefields.randomAlphabetic(4);
		return"{\r\n"
				+ "  \"locationName\": \""+ location+"\",\r\n"
				+ "  \"sampleMainId\": 924357782,\r\n"
				+ "  \"screenId\": 1115078699,\r\n"
				+ "  \"remarks\": \""+remarks+"\"\r\n"
				+ "}";
	}
	
	public static String SampleMain()
	{
		String sampleName ="sample"+Reusablefields.randomAlphabetic(5);
		
		return"{\r\n"
				+ "  \"availability\": false,\r\n"
				+ "  \"ppjoMainId\": 174351285,\r\n"
				+ "  \"salesExecutiveId\": 1615093622,\r\n"
				+ "  \"sampleName\": \""+sampleName+"\",\r\n"
				+ "  \"screenId\": 14577231\r\n"
				+ "}";
		
		
	}
			
}

