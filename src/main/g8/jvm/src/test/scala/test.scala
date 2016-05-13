import org.scalatest.{Matchers,FunSpec}

class Spec extends FunSpec with Matchers {

	describe("x"){
		it("y"){
			1 should equal(1)
		}
	}

}