# Animal Shelter
___

###JSF + Spring integration
To make Spring's bean and JSF's bean working together it's necessary to define `SpringBeanFacesELResolver` in [faces-config.xml](https://github.com/Karina-Denisevich/Animal-shelter-web/blob/master/src/main/webapp/WEB-INF/faces-config.xml)
```xml
<application>
        <el-resolver>
            org.springframework.web.jsf.el.SpringBeanFacesELResolver
        </el-resolver>
</application>
```
