package javaBase.enums;


/**
 * @author ybt
 *Testenum testenum=Testenum.BLANK;
 *testenum.ordinal();
 *testenum.name();
 */
public enum Testenum {  
    RED("红色","描述", 1), GREEN("绿色","描述", 2), BLANK("白色","描述", 3), YELLO("黄色","描述", 4);  
    // 成员变量  
    private String name;  
    private int index;
    private String miaos;
    // 构造方法  
    private Testenum(String name,String miaos, int index) {  
        this.name = name;  
        this.index = index;
        this.miaos=miaos;
    }  
//    // 普通方法  
//    public static String getName(int index) {  
//        for (Testenum c : Testenum.values()) {  
//            if (c.getIndex() == index) {  
//                return c.miaos;  
//            }  
//        }  
//        return null;  
//    }  
//    // get set 方法  
//    public String getName() {  
//        return name;  
//    }  
//    public void setName(String name) {  
//        this.name = name;  
//    }  
//    public int getIndex() {  
//        return index;  
//    }  
//    public void setIndex(int index) {  
//        this.index = index;  
//    }
//	public String getMiaos() {
//		return miaos;
//	}
//	public void setMiaos(String miaos) {
//		this.miaos = miaos;
//	}  
    
}  
