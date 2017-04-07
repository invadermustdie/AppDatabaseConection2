package bo.com.alegutierrez.appdbconection;


public class Config {

    //Address of our scripts of the CRUD
    public static final String URL_ADD="http://10.1.2.129/essa2/add.php";
    public static final String URL_GET_ALL = "http://10.1.2.129/essa2/getAll.php";
    public static final String URL_GET_EMP = "http://10.1.2.129/essa2/get.php?id=";
    public static final String URL_UPDATE_EMP = "http://10.1.2.129/essa2/update.php";
    public static final String URL_DELETE_EMP = "http://10.1.2.129/essa2/delete.php?id=";

    //Keys that will be used to send the request to php scripts
    public static final String KEY_EMP_ID = "id";
    public static final String KEY_EMP_IMEI = "imei";
    public static final String KEY_EMP_MACBT = "macbt";
    public static final String KEY_EMP_ECOM = "ecom";

    //JSON Tags
    public static final String TAG_JSON_ARRAY="result";
    public static final String TAG_ID = "id";
    public static final String TAG_NAME = "name";
    public static final String TAG_DESG = "desg";
    public static final String TAG_SAL = "salary";

    //employee id to pass with intent
    public static final String EMP_ID = "emp_id";
}
