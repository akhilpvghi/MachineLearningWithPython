restfulwebservices V/s microservices

github.com/in28minutes/springMicroserices


finchley.M8---spring cloud--->tools

what is web services--->service delivered over the web..??
--->interoperable machine-to-machine interaction

to provide new jar again and again??

how data exchange take place??

Application consumes--->web services--->

request and response--->from application to web services and vice-versa

web-services should be platform independent---->(Message Exchange format)---->XML===>platform independent
					   ---->JSOn===>


service definition--->1) Req,res 2)End point,3)STructure


HTTP and MQ--->

Web service grp----->

SOAP--->simple object access protocol
   we use XML

its own struture


service Definition
WSDL




 
REST--->
representational state transfer--->make best use of http

	

soap v/s rest


____________________________________________________________

SpringBoot with microservices

microservices with spring CLoud

github.com/in28minutes/spring-microserices

small autonomous services that work together--->

microservices

REST
&small deployable units
&cloud enabled 

challenges with microservices--->

bounded context====>Right boundary=====> MS1-->MS2--MS3--->MS4
configuration management===>MS1 can have multiple instances
Dynamic scale-up and scale-down==>balance load among active states
visibility===>like identify bugs===>maintain logs
pack of cards===>diadv of bus topology==>fault tolerance


Introduction to Spring CLoud

cloud.spring.io
 
----> Naming server (Eureka)---->features---service registration and service discovery

---->Ribbon(load balancing)

Hysterix--->fault tolerance


Advantages of microservice Architecture--->

process very easily--->
MS1-->may be java
MS2---> may be node

adv--->dynamic scaling
--->faster release cycle

03.microservices in github--->

many ports and url to keep track of

------_______________________________

start.spring.io

choose-------->maven and java--->2.0.0M3

choose group--->com.akhil.microservice


dependencies
----->devTools--->so that server can pick changes directly without restarting
---->configClient
------>web
----->Actuator


now generate project

in application.properties

spring.application.name=
server.port


create another project for spring-cloud-config-server===>this is artifact

dependencies--->
1)dev tools--->so that server can pick changes directly without restarting
2)config server

give name in application.properties

spring.application.name=spring-cloud-config-server
server.port=8888
_____________________________________________________________

install git

--------->try git

in any folder try --->git init

link path to git repo---->build path--->
									
we are creating local git repo and linking to config project of ours

_______________________
EP-63
in config project---->
configure local git url--->

spring.cloud.config.server.git.uri=file:///"location"


NOW ENABLE SPRING CONFIG SEVER
@EnableConfigServer 


________________________________________________

EP--64

different enviroment config of same project---->
crate different properties file for different environment

if some property is not present it will pick up ---from default properties file

now all these config can be accessed by url by file name
works on priority basis


______________________________

EP 65

change name from application.properties to bootstrap.properties

spring.application.name=limit-service
spring.cloud.config.uri=http://localhost:8888

____________________________________________________________

EP-66

in order to use specific profile--->

spring.profiles.active=dev



____________________________________________________

EP-67


__________________________________________

E68

create new project
dependecies-->devtool,actuator,web,configCLient

app.properties---->

spring.application.name="artifact Id"
server.port=8000


@RestController---->to mark hit-->to get the service abve class name

________________________________________________________________________

Ep-71

@Autowired================?preExisting class by spring
private Environment envirnment

Integer.parseInt(envirnment.getProperty("port"))


EP-72

pom-----data-jpa--->with H2

JPA--->@Entity
	public class .....

@Id

@Column-name=""-->have var name like from

h2-console with JPA
_________________________________
E73

create JPA repsitory as interface

____________________________________________

E74

dependencies---------->web,devTool,Actuator.configClient

in application.poroperties
appliction.name=currency-conversion-service
server.port=8100

________________________________________
E75

new class 
@restcontroller

@GetMapping("url")
fn( @pathVariable String fromUrl, @pathVariable String def, ....)

___________________________________________________________

E78
@SpringBootAplication
@EnableFeignClients("package_name")



in interface
@FeignClient(name="service_name", url="localhost:port")


if we use feign pathvariable is necessary("var name")


__________________________________________________

E79

Adding ribbon to balance load



translate----->on progress---output mein h, 

shipment code--->task code

volume,size

service-type--->
fp-pickup else delivery

if only volume---->close all contraint

id---->shipment_code


to make repo public---->open repo--->go to setting---->Danger Zone-->make public

_____________________________________________________

Spring MVC......S14E1...luv2code

Form tags with spring..... Support data binding

Regular html

In be spring tag on jao

Again regular html

_______________________
S14E2

ShowForm( model model){

}


<Form: form modalatteibute="student">

  <Form: input.  >

When submit...... Automatically calls setter methods.....


ProcessForm(@Modelattrribute("student") student thestudent)

.....

Create student class


Control class

Html form

Handle html

Confirmation page

_________________________

postgres timeStamp Issue

https://medium.com/@AADota/spring-jpa-native-query-for-date-time-mysql-and-postgresql-17b2b8a40e68



_______________________________________

Spring MVC


S14e3

Create Student class.....

Private first name

Private last name...


Public No arg constructor...

Generate getter and setter....

------------
@Controller
@requestMapping("/student")
New class-------studentController

@requestMapping( "/showForm")
Public String showForm( model model)

Student s = new student()

model.add attribute("student", s)

Return string;

---------------------------
S14e4



Web-inf ---->view--->Student-form.jsp

taglib uri is necessary....

Doc type html

Html
Head head
Body

Form : form action modelattribute

Form; input  path first-name

Input type submit value submit-----> will call setters





Body

Html
+==========================

Request mapping process form

Public String process form (   @model attribute(.  "Student") student student)

Student. GetName 

---------------]]]---------------------_----------

S14e5
Spring MVC form tags...
Student-confirmation.jsp
In html

${student.firstName}

Navigate by <a href....

-----------------
S14e6

Drop down list....

In form....

From: select

Form: option value and label....
-----------------

S14e7
In jao

Country :

Form: select path="country"-----will call student.setCountry

${student.country}---->will call student.getCountry

-----------------------------

S14e8

Options in java only...

LinkedHashMap<String, String> country-option = new Linked HashMap<>;

Country_option.put("BR","Brazil");
.
.
. 
And so on.

First one is value and label is second for jsp

------

In our form.....

Form: options  items=${student. Country Options}

------------------

S14E9


