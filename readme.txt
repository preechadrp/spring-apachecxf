
=== ดูโครงสร้าง
http://localhost:8080/ws/hello?wsdl

=== ใช้ทดสอบยิ่งผ่าน soupui
<soapenv:Envelope
 xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
 xmlns:ser="http://service.soap.example.com/">

    <soapenv:Header>

        <ser:authHeader>
            <userId>john</userId>
            <token>abc123</token>
        </ser:authHeader>

    </soapenv:Header>

    <soapenv:Body>

        <ser:sayHello>
            <request>
                <name>Preecha</name>
            </request>
        </ser:sayHello>

    </soapenv:Body>

</soapenv:Envelope>

===ทดสอบ failed

<soapenv:Envelope
    xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
    xmlns:ser="http://service.soap.example.com/">

    <soapenv:Body>
        <ser:sayHello>
            <request/>
        </ser:sayHello>
    </soapenv:Body>

</soapenv:Envelope>

