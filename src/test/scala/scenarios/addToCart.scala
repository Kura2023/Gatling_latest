package scenarios

import config.BaseHelpers.thinkTimer
import io.gatling.core.Predef._
import io.gatling.core.structure._
import io.gatling.http.Predef._

object addToCart {
  def scnLocalhostDesc: ScenarioBuilder =
  {
    scenario("add items to cart")
      .exec(flushHttpCache)
      .exec(flushCookieJar)
      .exitBlockOnFail(
        group("homepage") {
          exec(api.home.blazeHome())
            .exec(thinkTimer())
        }
          .group("tables"){
            exec(api.tables.secondpage())
              .exec(thinkTimer())
          }
          .group("table_selection"){
            exec(api.tableselection.tableselection())
              .exec(thinkTimer())
          }
          .group("add_table_to_cart"){
            exec(api.addtabletocart.addtable())
              .exec(thinkTimer())
          }
        //  .group("click_chairs"){
          //  exec(api.clickchairs.clickonchairs())
           //   .exec(thinkTimer())
         // }
          .group("random_chair"){
            exec(api.randomchair.selectchair())
              .exec(thinkTimer())
          }
          .group("add_chair_to_cart"){
            exec(api.addchairtocart.addchair())
              .exec(thinkTimer())
          }
          .group("checkout"){
            exec(api.checkout.checkout())
              .exec(thinkTimer())
          }
          .group("open_cart"){
            exec(api.opencart.cart())
              .exec(thinkTimer())
          }
      )
  }
}
