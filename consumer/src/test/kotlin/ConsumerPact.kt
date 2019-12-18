import  au.com.dius.pact.consumer.ConsumerPactTestMk2
import au.com.dius.pact.consumer.MockServer
import au.com.dius.pact.consumer.dsl.PactDslJsonBody
import au.com.dius.pact.consumer.dsl.PactDslWithProvider
import au.com.dius.pact.model.RequestResponsePact
import com.github.kittinunf.result.Result
import org.example.WeatherClient
import org.junit.Assert

class ConsumerPact:ConsumerPactTestMk2() {

    val citid=1851632

    override fun runTest(mockServer: MockServer) {
        val client=WeatherClient(mockServer.getUrl())

        when (val result=client.getById(citid)){
            is Result.Failure ->
                Assert.fail()
            is Result.Success ->
                println("This has passed")

        }

    }

    override fun createPact(builder: PactDslWithProvider): RequestResponsePact=
            builder.uponReceiving("a weather report request")
                    .matchPath("/weather/(.*)","/weather/1234")
                    .method("GET")
                    .willRespondWith()
                    .status(200)
                    .body(buildBody(1851632))
                    .toPact()

    fun buildBody(id:Int):PactDslJsonBody=
            PactDslJsonBody().numberType("id",id)
                    .stringType("name","Shuzenji")
                    .numberType("timezone",32400)
                    //.`object`("clouds").numberType("all",2)
                    //.closeObject()
                    .`object`("wind").numberType("deg",107.538F).numberType("speed",0.47).closeObject()
                    .asBody()

    override fun consumerName(): String ="weather-consumer"

    override fun providerName(): String ="weather-producer"

}