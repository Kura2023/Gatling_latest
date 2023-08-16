package simulation

import config.BaseHelpers._
import io.gatling.core.Predef._
import scenarios.addToCart.scnLocalhostDesc

class PerfTestSimulation extends Simulation {

  //mvn gatling:test
  //mvn clean gatling:test

  setUp(
    scnLocalhostDesc.inject(atOnceUsers( users = 1))
  ).protocols(httpProtocol)

}
