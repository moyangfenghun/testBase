package application.caiji;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.sql.RowSet;

import org.junit.Test;

import application.caiji.unitls.mySqlHelper_pool;
import javaBase.date.dateUtils;

public class rengwu {
	//18年7,10
	private static String enwpt="20190101";
	public static void main(String[] args) throws ParseException {
		String yuimng="http://datacollect.cnbkw.com:8088";
		ExecutorService service = Executors.newFixedThreadPool(15);
		rengwu rengwu=new rengwu();
		//推广
//		service.execute(new myThread(yuimng+"/tuiguang/extensionptpromotionanalysis", "size=15&startpt=20190101&endpt=20190331",2,rengwu));
//		service.execute(new myThread(yuimng+"/tuiguang/extensionptpromotionanalysis", "size=15&startpt=20190401&endpt=20190631",2,rengwu));
//		service.execute(new myThread(yuimng+"/tuiguang/extensionptpromotionanalysis", "size=15&startpt=20190701&endpt=20190831",2,rengwu));

//		service.execute(new myThread(yuimng+"/tuiguang/extensionptpromotionanalysis", "size=10&startpt=20190901&endpt=20191231",2,rengwu));
		
		
//		service.execute(new myThread(yuimng+"/tuiguang/extensionptpromotionanalysis", "size=15&startpt=20180101&endpt=20180230",2,rengwu));
//		service.execute(new myThread(yuimng+"/tuiguang/extensionptpromotionanalysis", "size=15&startpt=20180301&endpt=20180430",2,rengwu));
//		service.execute(new myThread(yuimng+"/tuiguang/extensionptpromotionanalysis", "size=15&startpt=20180501&endpt=20180630",2,rengwu));
//		service.execute(new myThread(yuimng+"/tuiguang/extensionptpromotionanalysis", "size=15&startpt=20180701&endpt=20180930",2,rengwu));
//		service.execute(new myThread(yuimng+"/tuiguang/extensionptpromotionanalysis", "size=15&startpt=20181001&endpt=20181231",2,rengwu));
//
//		service.execute(new myThread(yuimng+"/tuiguang/extensionptpromotionanalysis", "size=15&startpt=20170101&endpt=20170331",2));
//		service.execute(new myThread(yuimng+"/tuiguang/extensionptpromotionanalysis", "size=15&startpt=20170401&endpt=20170630",2));
//		service.execute(new myThread(yuimng+"/tuiguang/extensionptpromotionanalysis", "size=15&startpt=20170701&endpt=20170930",2));
//		service.execute(new myThread(yuimng+"/tuiguang/extensionptpromotionanalysis", "size=15&startpt=20171001&endpt=20171231",2));

//		service.execute(new myThread(yuimng+"/tuiguang/extensionptpromotionanalysis", "size=15&startpt=20160101&endpt=20160430",2));
//		service.execute(new myThread(yuimng+"/tuiguang/extensionptpromotionanalysis", "size=15&startpt=20160501&endpt=20160831",2));
//		service.execute(new myThread(yuimng+"/tuiguang/extensionptpromotionanalysis", "size=15&startpt=20160901&endpt=20161231",2));

//		service.execute(new myThread(yuimng+"/tuiguangnew/ordertotuiguang", "size=100",2,null));
//		service.execute(new myThread(yuimng+"/tuiguangnew/ordertotuiguang", "size=50&startpt=20191001&endpt=20191231",4,null));

		
//		service.execute(new myThread(yuimng+"/tuiguangnew/ordertotuiguang/promotionanalysisfree", "",2));
//		service.execute(new myThread(yuimng+"/tuiguangnew/ordertotuiguang/free", "",2));

		service.shutdown();
	}
	
	public synchronized String[] getnewpt() throws ParseException{
		String pt[]={"",""};
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyyMMdd");
		Date parse = dateFormat.parse(enwpt);
		Date calculatorDate = dateUtils.calculatorDate(parse,-3,dateUtils.MONTH);
		enwpt=dateFormat.format(calculatorDate);
		pt[0]=enwpt;
		Date calculatorDate2 = dateUtils.calculatorDate(parse,-1,dateUtils.DAY);
		pt[1]=dateFormat.format(calculatorDate2);
		return pt;
	}
	@Test
	public void test() throws ParseException{
		String sp1[]="'zckj_2850331e985b4452a61c5dbae3e74e','zckj_f2b66290e1cd4ab3afa789c385fde9','zckj_e787a2633db34336a8da115796c4d3','zckj_1c37adda29aa48f48096ceb0a79d07','zckj_4ea3c45a96994b7b8a049826619535','zckj_9c002526604348989131e0ea195894','zckj_af44d400c3054c6e81b335c94791c8','zckj_b04b888148804d71a324ca92f4f0e8','zckj_ed03f9fb52d94c53a5b7b0b428bf27','zckj_fef4ee7b5dda40c4b7f012dd17306b','zckj_ca5824de6ef2444fa626afb2c80623','zckj_386a1bbe23d842efb1e474b209dfeb','zckj_8f6666e9df2441048952b5e64692d7','zckj_3611ed7df6b34e61b6857f18823701','zckj_0aace3eb05e042988b0c950939d8fa','zckj_b6b9105d50d3400495d8de8a694644','zckj_0d3e98c19bc345b997c10e59005f78','zckj_343efcf184734e619236096ef9df7b','zckj_4b63b7037bc8472a8220312d2dec2e','zckj_d2996a6a2c434ca4b484e53ed6c6f7','zckj_667921ef17124d9b9157afed000afd','zckj_e3d9a217ce16476cba2d2dd8876c5a','zckj_2649ebf1d8164e58a4d7d1a8bbd624','zckj_57aafe4137db409299c3c9ff8cb94b','zckj_2eed726b367049eaaa8aed00306de5','zckj_0de19550aeae43518e52e954e8a61f','zckj_0661c70f3b384928a66038611d5147','zckj_f71aed6fabc94f45be4c97418d023e','zckj_68b7ac9f3004435bb7c22339ddd918','zckj_af41a2892809416badf0654525cb96','zckj_ae4f4f9b232842c299789bdf56d0ec','zckj_fd9d17fc67364965914224c2f83ae8','zckj_9c39dc2780e6446388e1e3a08fb2ef','zckj_47767ee8b3fe45a9af6fc318e23003','zckj_bda6818fc6ac4511b66329fbe63a5f','zckj_3f0a654513304d608ecf4ab5671356','zckj_b3c92b6a344249ebb3be1879c8101b','zckj_67a3978afff44974ae6a5215e744ab','zckj_df205c75cc514b7896d50fffb5e78c','zckj_854c3dd60e7242b99d0534f9d28287','zckj_cc6497638bda40b49a7e7cdc0ddf8e','zckj_c27bf12792c14d92ad6023b5e28fa0','zckj_9f5c18cd3b204cc68c3e599d63f16c','zckj_3a7758aab25148d4afa068a313ece2','zckj_c0f2c5ce3ec246f2985bd984ac0098','zckj_86eebc69583f471587f890d796fd47','zckj_23969ca2475849c695eaf37ec58529','zckj_26212c0b470440c8879638cf4c27c2','zckj_4ac25ebe2023433fb133014becd083','zckj_026cb94382804c0993b901f7a1020d','zckj_9066c39371644552be7a78ce4c9649','zckj_4f62af39b6524ee0aa6ec729d1c36b','zckj_4078cce94bfa4fd0b8c67dfbbb105e','zckj_73beac6758b245419c324c0e22d7d5','zckj_d2bd118615f64ff0a695efacb72a4c','zckj_b18598df9c81438cb8f53d78da5474','zckj_0068b7532194412d8a59b176a658ef','zckj_c5d5066ac4514e55a7c4d908da5e83','zckj_1e9d29fba6a549f19d6f538aa33c2e','zckj_e8179150b5e2485f8b8240b56ed260','zckj_69de5ea2df5448e985906e5cd4d9be','zckj_aec01ef1ad1d46be9f072b0acae371','zckj_05f67e5e9c064bceb6fa0f4b9858ce','zckj_8cb49f9d8f2445a4a82ebb24afadf5','zckj_7f6c715e13f54fa9b4ba134a693543','zckj_372dbbb9bd684c98b3147294a53172','zckj_85bb5cd0b5b04ce8bb3ea1cfb1eb7d','zckj_aeb4d858035c4fc2b590c581130936','zckj_8224665b95c148c0953b36a79d923f','zckj_2460d3d9584b44a991c786528a6ea4','zckj_38dac6103d634075a2dbf3b4c083cb','zckj_b80877f6f84642a59658541b3d5a8c','zckj_f335097c4da04ffbb944a79a51eab6','zckj_af91a5687f5745088ba23ea668aad2','zckj_273024bbd63a4212851091ac32693f','zckj_5aa5c957b0d642c5a7cab39158e13b','zckj_bea016f36b3c4aa38520aaa78b2c8c','zckj_f7381f649fd54043bf4bae51043fef','zckj_4bc81a7973904251ab100ccf6f3a07','zckj_00cdc53968304053b3b0544151beb4','zckj_fac488bcb40a4b509016f2bba2ff1b','zckj_985a0fb26bc743708159cd24675a1c','zckj_7915b9c07df140d99f9b9c72d91f90','zckj_a976c7dae5c6456d8b90bd998f2baa','zckj_ec94d87dc0e44d488bab656c870554','zckj_c07a9f207b4040abbd483932a92588','zckj_0404ca0a00f8438081b37589316ae9','zckj_4ba3118c9c7f4fc0b3c6b94d2c9755','zckj_490af76767f6483a90887ff772f515','zckj_f9f7853b148641213c05a3b8055d7e','zckj_ee02ebca9e07477f8cf762730cefa4','zckj_53915004df354850832eff0af50684','zckj_8f9a030d53284f96b69ef529132784','zckj_3102cb9ffb8a4af1a25557d64b8716','zckj_59f53e20efad4edeacb0a6d484a956','zckj_8dd16dda13dd4fb79589d199dd63c0','zckj_fa66ff69aa50496ea46fc0d63a5fbe','zckj_99768674edfa42c3af3370d986ff7e','zckj_c9ea5fa3ebcb4e35a7807bd68a5b28','zckj_545abe027a8244628ab04e24d4d6af','zckj_79993e3ca27a4e02bb5771ce97ce6c','zckj_fea19fa21c7847839cff4a3e8566c1','zckj_3527739c47c04a3193e1ba727ce04f','zckj_bf1bc2dfead946a3bcd01f527616f3','zckj_d0ffa394782048be8c40ff68c49665','zckj_0070c70d5f06424fadd0039c0970a5','zckj_ddbb5a718ea3484bbebad73bae8e9d','zckj_160b733e19514255be7f9e4fb11354','zckj_30caf2c9f8f44c50afb11e35917aba','zckj_222656c35a0b4f6ba6250005cbc363','zckj_f30577c7280d4f5d8dadb2e5bc3910','zckj_f1b67104b90c489a9993be0cc17400','zckj_bfbc756b19fa4c6eafc9bf488038d8','zckj_6466af5174684fd1a1234429c21d04','zckj_928fbcd9b1174289b1273b693cbfa3','zckj_0ef6b0027e7b4f9c8361e2e319c9da','zckj_b2740f93dc0f427e822f36a66b3f02','zckj_c79ad67243674a20adf577707f143d','zckj_47678419607c4b9c8e229f75c90ff3','zckj_90212bb7ace1403b9c3bb555a30e55','zckj_caf8ebd0b9884e2dad4cd558f39f91','zckj_268101881178468ebe980683df3f9c','zckj_129237f5b178483db672a983663492','zckj_ff1e041888094834a2fea2a17d3b38','zckj_a0d6244f9d2844dc9cfb154e2d266c','zckj_ad940407de9842fda47a7d255a7940','zckj_023bf74358ca4f06904dbbfa8e10f3','zckj_2f0407820d7b486d862c6a5efbf8a3','zckj_2613fb340f48495eba47cdc887fe74','zckj_f774871bada544e58e8eaf0c4c85f5','zckj_8704f6e55f64411f99ba886716eb89','zckj_28fc08bbaa3940768de6715ede900f','zckj_836776f91eee49c98c8cecbc33035b','zckj_30817182cda14bab87f53ecc316cbc','zckj_cba8e861bea5432f8afa3bf2031d50','zckj_a3f59d3b689a459e870339d6b4c12a','zckj_6cfdf0658e9e49bcaca333f67f1d6c','zckj_98536cb87c4e40fd99982630318b80','zckj_673600184d72426283cab2ebdaf588','zckj_0518df6aa3d748f4ab175b6f55e575','zckj_8eee7c4632414af9ba8f1686ba05eb','zckj_a027d3b1d1d4439283a9a82b630141','zckj_a46d76501aa842cea3972fbdb2de1c','zckj_1d9f5501af3b4578b3b26cf6c22be0','zckj_c6be595eb12c4436839796f14421d7','zckj_cfffc3fd3d344295a40ad32b309547','zckj_489e0d3640c247df8436a1b1ca1d52','zckj_7aa214e7f93d40cdb28dc6af63af8c','zckj_38e1803680d54b4894f20028395f43','zckj_cd2306897ee94542be84b1c973eea4','zckj_257ee3c8485a4a78957bc9aad02708','zckj_eea17829a6354320814d8cf1c65d6f','zckj_738e3cc2fa294d3e88e5eeb05769e6','zckj_ae8b2d8ba1a640b3b9219ba7e21018','zckj_6a6e219fe1194986a42df57af3ef90','zckj_999ae2a9016545dca2517c564d5f30','zckj_256542e1ddcf44429575164665a0ef','zckj_0096451d5790453ca12c237536fc00','zckj_e256b493bf98416a9ed025447ce3f1','zckj_8e62b5f84abd4f1281bdca291d5795','zckj_5c2b601a50404a2ca8cdd39ed64a46','zckj_786bd2878f4049588a9dba1b79ae25','zckj_723bf3f684ef41c08af8687d4540e8','zckj_cb26a5a3fefa4c8684fab62a1295bb','zckj_aed218ad2591462195eb3bf59bad27','zckj_003e86de342a4c76affe4fd837758e','zckj_22d48943eef44b37a3d207d23c66c6','zckj_24bd28078b48496b9172271a25db07','zckj_fa7ee5eafc92402f9c64c50aaac759','zckj_42844535eba04abe850c96e9d9b607','zckj_6ffc4ac4b782431da3bab14e9b5478','zckj_7145e898338846f79ebcc2fe06097c','zckj_6cbe0967e75241cdb35a8441831f33','zckj_99a1531e3cb642d9bbbbe923ef5cf7','zckj_75e67c5b882f44baa8cd3d962e28eb','zckj_fe1a600caf114f759934dba09d4dbf','zckj_fb1788b0530d4dbd8387aee87beff5','zckj_3f428076b5ff457290e07c9bbd6b9f','zckj_5336d8224cc542b5966a3cffcffd3c','zckj_baddebafb1694b5c871452fa899ec0','zckj_fe0c9af9635b4a66b460985e8bf528','zckj_cc00a93deafd49a8a58b34589059ef','zckj_a7c0c2cda3fb469e82c9024487be3d','zckj_132f1446880240b9823fe42b8c6bb0','zckj_7bb57d5b41804f53a91e85ac78afd5','zckj_99ce02b5294e42838afe5db3d4b8b5','zckj_dd71d7ea223e49b8b88142937926f5','zckj_ee755c0174514f29a47ffb3a0493d7','zckj_6e64e28351384711971c70d8986a37','zckj_3c1e21fb2f9f4dfda7253fdca21c32','zckj_21a718c884934c5089bc02dd4b219a','zckj_f22ea7a4b69b452983ec3dbeb07969','zckj_77792192bf1a4923a4a7495a950025','zckj_af6be6b8efc84bfda21a840e87ea71','zckj_d0246b1aa9b34ff8b1420d3b6569da','zckj_1e17913f89be4effab111845b2fa43','zckj_6f5b15e8526246de80ef630d19a672','zckj_f64bde4067e347ccb46dd103a7f160','zckj_811450897df043df84530d7a0a267b','zckj_79272fd022054fc7a32171113253f4','zckj_0d56ab1c97574e4ebb05f9425fc18d','zckj_fe129d29be4f41f98befc1fa0738bc','zckj_51545093ee8740d7a1545a74948b3d','zckj_452cc6c42649453382a8de313497df','zckj_2e88b8c614da4cea98ec57c6bc839a','zckj_84cae49f9c954041b1cd5a0f8753cc','zckj_5af7a70c28714f718567f5e92d335f','zckj_9e39f90d975e481886e361e0d1709b','zckj_583ae82c53494d99a970aeb3eaf3c3','zckj_5b66af50da0646479a23fe2defec44','zckj_f078ef672eb8423fa0ddf5c7b8a63f','zckj_e7f4b0a3d955426497b8dbe9e5fae6','zckj_9f3004cd7e024390b9acf4742d935b','zckj_e14c3bd936f54041a97ab56758bbe7','zckj_cbf85269b77c40c3bd72a7f32218b5','zckj_0c4380de30984cd3ab32df8fc0ac41','zckj_2bf29d8d95f84828ac1bd5680d7974','zckj_62b68c7e580b487b974a1db489332b','zckj_9ad1c8c216754c218455fd6ce84261','zckj_11b7645631054e6dabedf11f8478e5','zckj_b248b21c585748c7a2e1c0bcf80dba','zckj_858790a3085a4931a919203ffa2742','zckj_9519a08b7fe940faafe30b4494ba1b','zckj_cb84bd3b69734bf48247e440bd9072','zckj_efb95d6b745d4024870f8a54602c26','zckj_aedd74e6a7d14d0dbb03ea78507662','zckj_77730d8b19084e609aac1d6fc215c7','zckj_e6933ddb5af142e3a5a6b47a5e346b','zckj_2e3fce5eb50649c49ca1d0eb05bc37','zckj_7c5e9827883b495ab879121aac9111','zckj_496f65d333c6417d9284f47f01519c','zckj_7c466d79b57c4826ade6f15929c03f','zckj_1d3e312cceda43beb1126a6ba1cf63','zckj_5b61207ffa3c4f81b83cac07e4f9ea','zckj_6ba2b9b96f87474fa7416c2f4633cc','zckj_c57ff377fd204ae7873a230a0b9170','zckj_8d184aec233c44bdbd1119c0fcfc6f','zckj_9e23453890ed42789535de2110eca5','zckj_3ecb63f3ac6b4f59ae3b7f08e47d39','zckj_4b845c7c108a4da38fdffeb7c14a9e','zckj_b9c0baf107ed455aaede2f5bd3b26a','zckj_32efa662176c406e8ec06959309679','zckj_726bbd49be364c9cbc1955aedb0cee','zckj_0a961a131ab04d4ea4698614ccdb46','zckj_2876622460634daab11108d436360d','zckj_12327014c759468f9753adb5edcb2a','zckj_a1de44ec337049eeafd89688346b52','zckj_24a5e33a66d841f8bbed2be5b768ea','zckj_cae8e72985f6467aa5c25bb10fc4fc','zckj_740edaf55d204b1e88009d70381fbe','zckj_18d962f4c6144314b825426a09a8a9','zckj_a97d329916db4aae86a1908188219a','zckj_1a21d616de8f45948a331fafdf0948','zckj_e51462b4da7a4feaace49eb06dd8d9','zckj_231e1a9b0bd94804ada5eb3a9bdb92','zckj_356e19a544ad486f9db0ebc47d6629','zckj_972965cbde4e4327b05144e7a5fea0'".replaceAll("'","").split(",");
		String sp2[]="zckj_003e86de342a4c76affe4fd837758e,zckj_0068b7532194412d8a59b176a658ef,zckj_0070c70d5f06424fadd0039c0970a5,zckj_0096451d5790453ca12c237536fc00,zckj_00cdc53968304053b3b0544151beb4,zckj_023bf74358ca4f06904dbbfa8e10f3,zckj_026cb94382804c0993b901f7a1020d,zckj_0404ca0a00f8438081b37589316ae9,zckj_0518df6aa3d748f4ab175b6f55e575,zckj_05f67e5e9c064bceb6fa0f4b9858ce,zckj_0661c70f3b384928a66038611d5147,zckj_0a961a131ab04d4ea4698614ccdb46,zckj_0aace3eb05e042988b0c950939d8fa,zckj_0c4380de30984cd3ab32df8fc0ac41,zckj_0d3e98c19bc345b997c10e59005f78,zckj_0d56ab1c97574e4ebb05f9425fc18d,zckj_0de19550aeae43518e52e954e8a61f,zckj_0ef6b0027e7b4f9c8361e2e319c9da,zckj_11b7645631054e6dabedf11f8478e5,zckj_12327014c759468f9753adb5edcb2a,zckj_129237f5b178483db672a983663492,zckj_132f1446880240b9823fe42b8c6bb0,zckj_160b733e19514255be7f9e4fb11354,zckj_18d962f4c6144314b825426a09a8a9,zckj_1a21d616de8f45948a331fafdf0948,zckj_1c37adda29aa48f48096ceb0a79d07,zckj_1d3e312cceda43beb1126a6ba1cf63,zckj_1d9f5501af3b4578b3b26cf6c22be0,zckj_1e17913f89be4effab111845b2fa43,zckj_1e9d29fba6a549f19d6f538aa33c2e,zckj_21a718c884934c5089bc02dd4b219a,zckj_222656c35a0b4f6ba6250005cbc363,zckj_22d48943eef44b37a3d207d23c66c6,zckj_231e1a9b0bd94804ada5eb3a9bdb92,zckj_23969ca2475849c695eaf37ec58529,zckj_2460d3d9584b44a991c786528a6ea4,zckj_24a5e33a66d841f8bbed2be5b768ea,zckj_24bd28078b48496b9172271a25db07,zckj_256542e1ddcf44429575164665a0ef,zckj_257ee3c8485a4a78957bc9aad02708,zckj_2613fb340f48495eba47cdc887fe74,zckj_26212c0b470440c8879638cf4c27c2,zckj_2649ebf1d8164e58a4d7d1a8bbd624,zckj_268101881178468ebe980683df3f9c,zckj_273024bbd63a4212851091ac32693f,zckj_2850331e985b4452a61c5dbae3e74e,zckj_2876622460634daab11108d436360d,zckj_28fc08bbaa3940768de6715ede900f,zckj_2bf29d8d95f84828ac1bd5680d7974,zckj_2e3fce5eb50649c49ca1d0eb05bc37,zckj_2e88b8c614da4cea98ec57c6bc839a,zckj_2eed726b367049eaaa8aed00306de5,zckj_2f0407820d7b486d862c6a5efbf8a3,zckj_30817182cda14bab87f53ecc316cbc,zckj_30caf2c9f8f44c50afb11e35917aba,zckj_3102cb9ffb8a4af1a25557d64b8716,zckj_32efa662176c406e8ec06959309679,zckj_343efcf184734e619236096ef9df7b,zckj_3527739c47c04a3193e1ba727ce04f,zckj_356e19a544ad486f9db0ebc47d6629,zckj_3611ed7df6b34e61b6857f18823701,zckj_372dbbb9bd684c98b3147294a53172,zckj_386a1bbe23d842efb1e474b209dfeb,zckj_38dac6103d634075a2dbf3b4c083cb,zckj_38e1803680d54b4894f20028395f43,zckj_3a7758aab25148d4afa068a313ece2,zckj_3c1e21fb2f9f4dfda7253fdca21c32,zckj_3ecb63f3ac6b4f59ae3b7f08e47d39,zckj_3f0a654513304d608ecf4ab5671356,zckj_3f428076b5ff457290e07c9bbd6b9f,zckj_4078cce94bfa4fd0b8c67dfbbb105e,zckj_42844535eba04abe850c96e9d9b607,zckj_452cc6c42649453382a8de313497df,zckj_47678419607c4b9c8e229f75c90ff3,zckj_47767ee8b3fe45a9af6fc318e23003,zckj_489e0d3640c247df8436a1b1ca1d52,zckj_490af76767f6483a90887ff772f515,zckj_496f65d333c6417d9284f47f01519c,zckj_4ac25ebe2023433fb133014becd083,zckj_4b63b7037bc8472a8220312d2dec2e,zckj_4b845c7c108a4da38fdffeb7c14a9e,zckj_4ba3118c9c7f4fc0b3c6b94d2c9755,zckj_4bc81a7973904251ab100ccf6f3a07,zckj_4ea3c45a96994b7b8a049826619535,zckj_4f62af39b6524ee0aa6ec729d1c36b,zckj_51545093ee8740d7a1545a74948b3d,zckj_5336d8224cc542b5966a3cffcffd3c,zckj_53915004df354850832eff0af50684,zckj_545abe027a8244628ab04e24d4d6af,zckj_57aafe4137db409299c3c9ff8cb94b,zckj_583ae82c53494d99a970aeb3eaf3c3,zckj_59f53e20efad4edeacb0a6d484a956,zckj_5aa5c957b0d642c5a7cab39158e13b,zckj_5af7a70c28714f718567f5e92d335f,zckj_5b61207ffa3c4f81b83cac07e4f9ea,zckj_5b66af50da0646479a23fe2defec44,zckj_5c2b601a50404a2ca8cdd39ed64a46,zckj_62b68c7e580b487b974a1db489332b,zckj_6466af5174684fd1a1234429c21d04,zckj_667921ef17124d9b9157afed000afd,zckj_673600184d72426283cab2ebdaf588,zckj_67a3978afff44974ae6a5215e744ab,zckj_68b7ac9f3004435bb7c22339ddd918,zckj_69de5ea2df5448e985906e5cd4d9be,zckj_6a6e219fe1194986a42df57af3ef90,zckj_6ba2b9b96f87474fa7416c2f4633cc,zckj_6cbe0967e75241cdb35a8441831f33,zckj_6cfdf0658e9e49bcaca333f67f1d6c,zckj_6e64e28351384711971c70d8986a37,zckj_6f5b15e8526246de80ef630d19a672,zckj_6ffc4ac4b782431da3bab14e9b5478,zckj_7145e898338846f79ebcc2fe06097c,zckj_723bf3f684ef41c08af8687d4540e8,zckj_726bbd49be364c9cbc1955aedb0cee,zckj_738e3cc2fa294d3e88e5eeb05769e6,zckj_73beac6758b245419c324c0e22d7d5,zckj_740edaf55d204b1e88009d70381fbe,zckj_75e67c5b882f44baa8cd3d962e28eb,zckj_77730d8b19084e609aac1d6fc215c7,zckj_77792192bf1a4923a4a7495a950025,zckj_786bd2878f4049588a9dba1b79ae25,zckj_7915b9c07df140d99f9b9c72d91f90,zckj_79272fd022054fc7a32171113253f4,zckj_79993e3ca27a4e02bb5771ce97ce6c,zckj_7aa214e7f93d40cdb28dc6af63af8c,zckj_7bb57d5b41804f53a91e85ac78afd5,zckj_7c466d79b57c4826ade6f15929c03f,zckj_7c5e9827883b495ab879121aac9111,zckj_7f6c715e13f54fa9b4ba134a693543,zckj_811450897df043df84530d7a0a267b,zckj_8224665b95c148c0953b36a79d923f,zckj_836776f91eee49c98c8cecbc33035b,zckj_84cae49f9c954041b1cd5a0f8753cc,zckj_854c3dd60e7242b99d0534f9d28287,zckj_858790a3085a4931a919203ffa2742,zckj_85bb5cd0b5b04ce8bb3ea1cfb1eb7d,zckj_86eebc69583f471587f890d796fd47,zckj_8704f6e55f64411f99ba886716eb89,zckj_8cb49f9d8f2445a4a82ebb24afadf5,zckj_8d184aec233c44bdbd1119c0fcfc6f,zckj_8dd16dda13dd4fb79589d199dd63c0,zckj_8e62b5f84abd4f1281bdca291d5795,zckj_8eee7c4632414af9ba8f1686ba05eb,zckj_8f6666e9df2441048952b5e64692d7,zckj_8f9a030d53284f96b69ef529132784,zckj_90212bb7ace1403b9c3bb555a30e55,zckj_9066c39371644552be7a78ce4c9649,zckj_928fbcd9b1174289b1273b693cbfa3,zckj_9519a08b7fe940faafe30b4494ba1b,zckj_972965cbde4e4327b05144e7a5fea0,zckj_98536cb87c4e40fd99982630318b80,zckj_985a0fb26bc743708159cd24675a1c,zckj_99768674edfa42c3af3370d986ff7e,zckj_999ae2a9016545dca2517c564d5f30,zckj_99a1531e3cb642d9bbbbe923ef5cf7,zckj_99ce02b5294e42838afe5db3d4b8b5,zckj_9ad1c8c216754c218455fd6ce84261,zckj_9c002526604348989131e0ea195894,zckj_9c39dc2780e6446388e1e3a08fb2ef,zckj_9e23453890ed42789535de2110eca5,zckj_9e39f90d975e481886e361e0d1709b,zckj_9f3004cd7e024390b9acf4742d935b,zckj_9f5c18cd3b204cc68c3e599d63f16c,zckj_a027d3b1d1d4439283a9a82b630141,zckj_a0d6244f9d2844dc9cfb154e2d266c,zckj_a1de44ec337049eeafd89688346b52,zckj_a3f59d3b689a459e870339d6b4c12a,zckj_a46d76501aa842cea3972fbdb2de1c,zckj_a7c0c2cda3fb469e82c9024487be3d,zckj_a976c7dae5c6456d8b90bd998f2baa,zckj_a97d329916db4aae86a1908188219a,zckj_ad940407de9842fda47a7d255a7940,zckj_ae4f4f9b232842c299789bdf56d0ec,zckj_ae8b2d8ba1a640b3b9219ba7e21018,zckj_aeb4d858035c4fc2b590c581130936,zckj_aec01ef1ad1d46be9f072b0acae371,zckj_aed218ad2591462195eb3bf59bad27,zckj_aedd74e6a7d14d0dbb03ea78507662,zckj_af41a2892809416badf0654525cb96,zckj_af44d400c3054c6e81b335c94791c8,zckj_af6be6b8efc84bfda21a840e87ea71,zckj_af91a5687f5745088ba23ea668aad2,zckj_b04b888148804d71a324ca92f4f0e8,zckj_b18598df9c81438cb8f53d78da5474,zckj_b248b21c585748c7a2e1c0bcf80dba,zckj_b2740f93dc0f427e822f36a66b3f02,zckj_b3c92b6a344249ebb3be1879c8101b,zckj_b6b9105d50d3400495d8de8a694644,zckj_b80877f6f84642a59658541b3d5a8c,zckj_b9c0baf107ed455aaede2f5bd3b26a,zckj_baddebafb1694b5c871452fa899ec0,zckj_bda6818fc6ac4511b66329fbe63a5f,zckj_bea016f36b3c4aa38520aaa78b2c8c,zckj_bf1bc2dfead946a3bcd01f527616f3,zckj_bfbc756b19fa4c6eafc9bf488038d8,zckj_c07a9f207b4040abbd483932a92588,zckj_c0f2c5ce3ec246f2985bd984ac0098,zckj_c27bf12792c14d92ad6023b5e28fa0,zckj_c57ff377fd204ae7873a230a0b9170,zckj_c5d5066ac4514e55a7c4d908da5e83,zckj_c6be595eb12c4436839796f14421d7,zckj_c79ad67243674a20adf577707f143d,zckj_c9ea5fa3ebcb4e35a7807bd68a5b28,zckj_ca5824de6ef2444fa626afb2c80623,zckj_cae8e72985f6467aa5c25bb10fc4fc,zckj_caf8ebd0b9884e2dad4cd558f39f91,zckj_cb26a5a3fefa4c8684fab62a1295bb,zckj_cb84bd3b69734bf48247e440bd9072,zckj_cba8e861bea5432f8afa3bf2031d50,zckj_cbf85269b77c40c3bd72a7f32218b5,zckj_cc00a93deafd49a8a58b34589059ef,zckj_cc6497638bda40b49a7e7cdc0ddf8e,zckj_cd2306897ee94542be84b1c973eea4,zckj_cfffc3fd3d344295a40ad32b309547,zckj_d0246b1aa9b34ff8b1420d3b6569da,zckj_d0ffa394782048be8c40ff68c49665,zckj_d2996a6a2c434ca4b484e53ed6c6f7,zckj_d2bd118615f64ff0a695efacb72a4c,zckj_dd71d7ea223e49b8b88142937926f5,zckj_ddbb5a718ea3484bbebad73bae8e9d,zckj_df205c75cc514b7896d50fffb5e78c,zckj_e14c3bd936f54041a97ab56758bbe7,zckj_e256b493bf98416a9ed025447ce3f1,zckj_e3d9a217ce16476cba2d2dd8876c5a,zckj_e51462b4da7a4feaace49eb06dd8d9,zckj_e6933ddb5af142e3a5a6b47a5e346b,zckj_e787a2633db34336a8da115796c4d3,zckj_e7f4b0a3d955426497b8dbe9e5fae6,zckj_e8179150b5e2485f8b8240b56ed260,zckj_ec94d87dc0e44d488bab656c870554,zckj_ed03f9fb52d94c53a5b7b0b428bf27,zckj_ee02ebca9e07477f8cf762730cefa4,zckj_ee755c0174514f29a47ffb3a0493d7,zckj_eea17829a6354320814d8cf1c65d6f,zckj_efb95d6b745d4024870f8a54602c26,zckj_f078ef672eb8423fa0ddf5c7b8a63f,zckj_f1b67104b90c489a9993be0cc17400,zckj_f22ea7a4b69b452983ec3dbeb07969,zckj_f2b66290e1cd4ab3afa789c385fde9,zckj_f30577c7280d4f5d8dadb2e5bc3910,zckj_f335097c4da04ffbb944a79a51eab6,zckj_f64bde4067e347ccb46dd103a7f160,zckj_f71aed6fabc94f45be4c97418d023e,zckj_f7381f649fd54043bf4bae51043fef,zckj_f774871bada544e58e8eaf0c4c85f5,zckj_fa66ff69aa50496ea46fc0d63a5fbe,zckj_fa7ee5eafc92402f9c64c50aaac759,zckj_fac488bcb40a4b509016f2bba2ff1b,zckj_fb1788b0530d4dbd8387aee87beff5,zckj_fd9d17fc67364965914224c2f83ae8,zckj_fe0c9af9635b4a66b460985e8bf528,zckj_fe129d29be4f41f98befc1fa0738bc,zckj_fe1a600caf114f759934dba09d4dbf,zckj_fea19fa21c7847839cff4a3e8566c1,zckj_fef4ee7b5dda40c4b7f012dd17306b,zckj_ff1e041888094834a2fea2a17d3b38".split(",");
		Map<String,String> map=new HashMap<String, String>();
		
		for (int i = 0; i < sp2.length; i++) {
			map.put(sp2[i],i+"");
		}
		for (int i = 0; i < sp1.length; i++) {
			if(!map.containsKey(sp1[i])){
				System.out.println(i+"|"+sp1[i]);
			}
		}
		
	}
//	@Test
	public void test2() throws Exception  {
		String sql="SELECT * FROM keyword_detail WHERE keywordCode in ('zckj_2850331e985b4452a61c5dbae3e74e','zckj_f2b66290e1cd4ab3afa789c385fde9','zckj_e787a2633db34336a8da115796c4d3','zckj_1c37adda29aa48f48096ceb0a79d07','zckj_4ea3c45a96994b7b8a049826619535','zckj_9c002526604348989131e0ea195894','zckj_af44d400c3054c6e81b335c94791c8','zckj_b04b888148804d71a324ca92f4f0e8','zckj_ed03f9fb52d94c53a5b7b0b428bf27','zckj_fef4ee7b5dda40c4b7f012dd17306b','zckj_ca5824de6ef2444fa626afb2c80623','zckj_386a1bbe23d842efb1e474b209dfeb','zckj_8f6666e9df2441048952b5e64692d7','zckj_3611ed7df6b34e61b6857f18823701','zckj_0aace3eb05e042988b0c950939d8fa','zckj_b6b9105d50d3400495d8de8a694644','zckj_0d3e98c19bc345b997c10e59005f78','zckj_343efcf184734e619236096ef9df7b','zckj_4b63b7037bc8472a8220312d2dec2e','zckj_d2996a6a2c434ca4b484e53ed6c6f7','zckj_667921ef17124d9b9157afed000afd','zckj_e3d9a217ce16476cba2d2dd8876c5a','zckj_2649ebf1d8164e58a4d7d1a8bbd624','zckj_57aafe4137db409299c3c9ff8cb94b','zckj_2eed726b367049eaaa8aed00306de5','zckj_0de19550aeae43518e52e954e8a61f','zckj_0661c70f3b384928a66038611d5147','zckj_f71aed6fabc94f45be4c97418d023e','zckj_68b7ac9f3004435bb7c22339ddd918','zckj_af41a2892809416badf0654525cb96','zckj_ae4f4f9b232842c299789bdf56d0ec','zckj_fd9d17fc67364965914224c2f83ae8','zckj_9c39dc2780e6446388e1e3a08fb2ef','zckj_47767ee8b3fe45a9af6fc318e23003','zckj_bda6818fc6ac4511b66329fbe63a5f','zckj_3f0a654513304d608ecf4ab5671356','zckj_b3c92b6a344249ebb3be1879c8101b','zckj_67a3978afff44974ae6a5215e744ab','zckj_df205c75cc514b7896d50fffb5e78c','zckj_854c3dd60e7242b99d0534f9d28287','zckj_cc6497638bda40b49a7e7cdc0ddf8e','zckj_c27bf12792c14d92ad6023b5e28fa0','zckj_9f5c18cd3b204cc68c3e599d63f16c','zckj_3a7758aab25148d4afa068a313ece2','zckj_c0f2c5ce3ec246f2985bd984ac0098','zckj_86eebc69583f471587f890d796fd47','zckj_23969ca2475849c695eaf37ec58529','zckj_26212c0b470440c8879638cf4c27c2','zckj_4ac25ebe2023433fb133014becd083','zckj_026cb94382804c0993b901f7a1020d','zckj_9066c39371644552be7a78ce4c9649','zckj_4f62af39b6524ee0aa6ec729d1c36b','zckj_4078cce94bfa4fd0b8c67dfbbb105e','zckj_73beac6758b245419c324c0e22d7d5','zckj_d2bd118615f64ff0a695efacb72a4c','zckj_b18598df9c81438cb8f53d78da5474','zckj_0068b7532194412d8a59b176a658ef','zckj_c5d5066ac4514e55a7c4d908da5e83','zckj_1e9d29fba6a549f19d6f538aa33c2e','zckj_e8179150b5e2485f8b8240b56ed260','zckj_69de5ea2df5448e985906e5cd4d9be','zckj_aec01ef1ad1d46be9f072b0acae371','zckj_05f67e5e9c064bceb6fa0f4b9858ce','zckj_8cb49f9d8f2445a4a82ebb24afadf5','zckj_7f6c715e13f54fa9b4ba134a693543','zckj_372dbbb9bd684c98b3147294a53172','zckj_85bb5cd0b5b04ce8bb3ea1cfb1eb7d','zckj_aeb4d858035c4fc2b590c581130936','zckj_8224665b95c148c0953b36a79d923f','zckj_2460d3d9584b44a991c786528a6ea4','zckj_38dac6103d634075a2dbf3b4c083cb','zckj_b80877f6f84642a59658541b3d5a8c','zckj_f335097c4da04ffbb944a79a51eab6','zckj_af91a5687f5745088ba23ea668aad2','zckj_273024bbd63a4212851091ac32693f','zckj_5aa5c957b0d642c5a7cab39158e13b','zckj_bea016f36b3c4aa38520aaa78b2c8c','zckj_f7381f649fd54043bf4bae51043fef','zckj_4bc81a7973904251ab100ccf6f3a07','zckj_00cdc53968304053b3b0544151beb4','zckj_fac488bcb40a4b509016f2bba2ff1b','zckj_985a0fb26bc743708159cd24675a1c','zckj_7915b9c07df140d99f9b9c72d91f90','zckj_a976c7dae5c6456d8b90bd998f2baa','zckj_ec94d87dc0e44d488bab656c870554','zckj_c07a9f207b4040abbd483932a92588','zckj_0404ca0a00f8438081b37589316ae9','zckj_4ba3118c9c7f4fc0b3c6b94d2c9755','zckj_490af76767f6483a90887ff772f515','zckj_f9f7853b148641213c05a3b8055d7e','zckj_ee02ebca9e07477f8cf762730cefa4','zckj_53915004df354850832eff0af50684','zckj_8f9a030d53284f96b69ef529132784','zckj_3102cb9ffb8a4af1a25557d64b8716','zckj_59f53e20efad4edeacb0a6d484a956','zckj_8dd16dda13dd4fb79589d199dd63c0','zckj_fa66ff69aa50496ea46fc0d63a5fbe','zckj_99768674edfa42c3af3370d986ff7e','zckj_c9ea5fa3ebcb4e35a7807bd68a5b28','zckj_545abe027a8244628ab04e24d4d6af','zckj_79993e3ca27a4e02bb5771ce97ce6c','zckj_fea19fa21c7847839cff4a3e8566c1','zckj_3527739c47c04a3193e1ba727ce04f','zckj_bf1bc2dfead946a3bcd01f527616f3','zckj_d0ffa394782048be8c40ff68c49665','zckj_0070c70d5f06424fadd0039c0970a5','zckj_ddbb5a718ea3484bbebad73bae8e9d','zckj_160b733e19514255be7f9e4fb11354','zckj_30caf2c9f8f44c50afb11e35917aba','zckj_222656c35a0b4f6ba6250005cbc363','zckj_f30577c7280d4f5d8dadb2e5bc3910','zckj_f1b67104b90c489a9993be0cc17400','zckj_bfbc756b19fa4c6eafc9bf488038d8','zckj_6466af5174684fd1a1234429c21d04','zckj_928fbcd9b1174289b1273b693cbfa3','zckj_0ef6b0027e7b4f9c8361e2e319c9da','zckj_b2740f93dc0f427e822f36a66b3f02','zckj_c79ad67243674a20adf577707f143d','zckj_47678419607c4b9c8e229f75c90ff3','zckj_90212bb7ace1403b9c3bb555a30e55','zckj_caf8ebd0b9884e2dad4cd558f39f91','zckj_268101881178468ebe980683df3f9c','zckj_129237f5b178483db672a983663492','zckj_ff1e041888094834a2fea2a17d3b38','zckj_a0d6244f9d2844dc9cfb154e2d266c','zckj_ad940407de9842fda47a7d255a7940','zckj_023bf74358ca4f06904dbbfa8e10f3','zckj_2f0407820d7b486d862c6a5efbf8a3','zckj_2613fb340f48495eba47cdc887fe74','zckj_f774871bada544e58e8eaf0c4c85f5','zckj_8704f6e55f64411f99ba886716eb89','zckj_28fc08bbaa3940768de6715ede900f','zckj_836776f91eee49c98c8cecbc33035b','zckj_30817182cda14bab87f53ecc316cbc','zckj_cba8e861bea5432f8afa3bf2031d50','zckj_a3f59d3b689a459e870339d6b4c12a','zckj_6cfdf0658e9e49bcaca333f67f1d6c','zckj_98536cb87c4e40fd99982630318b80','zckj_673600184d72426283cab2ebdaf588','zckj_0518df6aa3d748f4ab175b6f55e575','zckj_8eee7c4632414af9ba8f1686ba05eb','zckj_a027d3b1d1d4439283a9a82b630141','zckj_a46d76501aa842cea3972fbdb2de1c','zckj_1d9f5501af3b4578b3b26cf6c22be0','zckj_c6be595eb12c4436839796f14421d7','zckj_cfffc3fd3d344295a40ad32b309547','zckj_489e0d3640c247df8436a1b1ca1d52','zckj_7aa214e7f93d40cdb28dc6af63af8c','zckj_38e1803680d54b4894f20028395f43','zckj_cd2306897ee94542be84b1c973eea4','zckj_257ee3c8485a4a78957bc9aad02708','zckj_eea17829a6354320814d8cf1c65d6f','zckj_738e3cc2fa294d3e88e5eeb05769e6','zckj_ae8b2d8ba1a640b3b9219ba7e21018','zckj_6a6e219fe1194986a42df57af3ef90','zckj_999ae2a9016545dca2517c564d5f30','zckj_256542e1ddcf44429575164665a0ef','zckj_0096451d5790453ca12c237536fc00','zckj_e256b493bf98416a9ed025447ce3f1','zckj_8e62b5f84abd4f1281bdca291d5795','zckj_5c2b601a50404a2ca8cdd39ed64a46','zckj_786bd2878f4049588a9dba1b79ae25','zckj_723bf3f684ef41c08af8687d4540e8','zckj_cb26a5a3fefa4c8684fab62a1295bb','zckj_aed218ad2591462195eb3bf59bad27','zckj_003e86de342a4c76affe4fd837758e','zckj_22d48943eef44b37a3d207d23c66c6','zckj_24bd28078b48496b9172271a25db07','zckj_fa7ee5eafc92402f9c64c50aaac759','zckj_42844535eba04abe850c96e9d9b607','zckj_6ffc4ac4b782431da3bab14e9b5478','zckj_7145e898338846f79ebcc2fe06097c','zckj_6cbe0967e75241cdb35a8441831f33','zckj_99a1531e3cb642d9bbbbe923ef5cf7','zckj_75e67c5b882f44baa8cd3d962e28eb','zckj_fe1a600caf114f759934dba09d4dbf','zckj_fb1788b0530d4dbd8387aee87beff5','zckj_3f428076b5ff457290e07c9bbd6b9f','zckj_5336d8224cc542b5966a3cffcffd3c','zckj_baddebafb1694b5c871452fa899ec0','zckj_fe0c9af9635b4a66b460985e8bf528','zckj_cc00a93deafd49a8a58b34589059ef','zckj_a7c0c2cda3fb469e82c9024487be3d','zckj_132f1446880240b9823fe42b8c6bb0','zckj_7bb57d5b41804f53a91e85ac78afd5','zckj_99ce02b5294e42838afe5db3d4b8b5','zckj_dd71d7ea223e49b8b88142937926f5','zckj_ee755c0174514f29a47ffb3a0493d7','zckj_6e64e28351384711971c70d8986a37','zckj_3c1e21fb2f9f4dfda7253fdca21c32','zckj_21a718c884934c5089bc02dd4b219a','zckj_f22ea7a4b69b452983ec3dbeb07969','zckj_77792192bf1a4923a4a7495a950025','zckj_af6be6b8efc84bfda21a840e87ea71','zckj_d0246b1aa9b34ff8b1420d3b6569da','zckj_1e17913f89be4effab111845b2fa43','zckj_6f5b15e8526246de80ef630d19a672','zckj_f64bde4067e347ccb46dd103a7f160','zckj_811450897df043df84530d7a0a267b','zckj_79272fd022054fc7a32171113253f4','zckj_0d56ab1c97574e4ebb05f9425fc18d','zckj_fe129d29be4f41f98befc1fa0738bc','zckj_51545093ee8740d7a1545a74948b3d','zckj_452cc6c42649453382a8de313497df','zckj_2e88b8c614da4cea98ec57c6bc839a','zckj_84cae49f9c954041b1cd5a0f8753cc','zckj_5af7a70c28714f718567f5e92d335f','zckj_9e39f90d975e481886e361e0d1709b','zckj_583ae82c53494d99a970aeb3eaf3c3','zckj_5b66af50da0646479a23fe2defec44','zckj_f078ef672eb8423fa0ddf5c7b8a63f','zckj_e7f4b0a3d955426497b8dbe9e5fae6','zckj_9f3004cd7e024390b9acf4742d935b','zckj_e14c3bd936f54041a97ab56758bbe7','zckj_cbf85269b77c40c3bd72a7f32218b5','zckj_0c4380de30984cd3ab32df8fc0ac41','zckj_2bf29d8d95f84828ac1bd5680d7974','zckj_62b68c7e580b487b974a1db489332b','zckj_9ad1c8c216754c218455fd6ce84261','zckj_11b7645631054e6dabedf11f8478e5','zckj_b248b21c585748c7a2e1c0bcf80dba','zckj_858790a3085a4931a919203ffa2742','zckj_9519a08b7fe940faafe30b4494ba1b','zckj_cb84bd3b69734bf48247e440bd9072','zckj_efb95d6b745d4024870f8a54602c26','zckj_aedd74e6a7d14d0dbb03ea78507662','zckj_77730d8b19084e609aac1d6fc215c7','zckj_e6933ddb5af142e3a5a6b47a5e346b','zckj_2e3fce5eb50649c49ca1d0eb05bc37','zckj_7c5e9827883b495ab879121aac9111','zckj_496f65d333c6417d9284f47f01519c','zckj_7c466d79b57c4826ade6f15929c03f','zckj_1d3e312cceda43beb1126a6ba1cf63','zckj_5b61207ffa3c4f81b83cac07e4f9ea','zckj_6ba2b9b96f87474fa7416c2f4633cc','zckj_c57ff377fd204ae7873a230a0b9170','zckj_8d184aec233c44bdbd1119c0fcfc6f','zckj_9e23453890ed42789535de2110eca5','zckj_3ecb63f3ac6b4f59ae3b7f08e47d39','zckj_4b845c7c108a4da38fdffeb7c14a9e','zckj_b9c0baf107ed455aaede2f5bd3b26a','zckj_32efa662176c406e8ec06959309679','zckj_726bbd49be364c9cbc1955aedb0cee','zckj_0a961a131ab04d4ea4698614ccdb46','zckj_2876622460634daab11108d436360d','zckj_12327014c759468f9753adb5edcb2a','zckj_a1de44ec337049eeafd89688346b52','zckj_24a5e33a66d841f8bbed2be5b768ea','zckj_cae8e72985f6467aa5c25bb10fc4fc','zckj_740edaf55d204b1e88009d70381fbe','zckj_18d962f4c6144314b825426a09a8a9','zckj_a97d329916db4aae86a1908188219a','zckj_1a21d616de8f45948a331fafdf0948','zckj_e51462b4da7a4feaace49eb06dd8d9','zckj_231e1a9b0bd94804ada5eb3a9bdb92','zckj_356e19a544ad486f9db0ebc47d6629','zckj_972965cbde4e4327b05144e7a5fea0')";
		RowSet executeQuery = mySqlHelper_pool.executeQuery(mySqlHelper_pool.Conn_thuiguang,sql , null);
		String keys="";
		int s=0;
		while(executeQuery.next()){
			s++;
			keys+= executeQuery.getString("keywordCode")+",";
		}
		System.out.println(s+"|"+keys);
	}
}