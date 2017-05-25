var ioc = {
	// 读取配置文件
    conf : {
        type : "org.nutz.ioc.impl.PropertiesProxy",
        fields : {
            paths : ["portal.properties","mail.properties"]
        }
    },
	dataSource: {
        type: "com.alibaba.druid.pool.DruidDataSource",
        events: {
            create: "init",
            depose: 'close'
        },
        fields: {
        	driverClassName : {java :"$conf.get('jdbc.driver')"},
            url: {java: "$conf.get('jdbc.url')"},
            username: {java: "$conf.get('jdbc.username')"},
            password: {java: "$conf.get('jdbc.password')"},
            initialSize     : 10,
            maxActive       : 100,
            testOnReturn    : true,
            testWhileIdle : true, // 非常重要,预防mysql的8小时timeout问题
            //validationQueryTimeout : 5,
            validationQuery : "select 1"
        }
    },
    dao: {
        type: "org.nutz.dao.impl.NutDao", // 1.b.53或以上版本使用原版NutDao.
        args: [{refer: "dataSource"}],
    }
}