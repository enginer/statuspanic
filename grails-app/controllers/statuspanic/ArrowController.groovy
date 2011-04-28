package statuspanic

class ArrowController {

    def module = { 
		def random = new Random()
		def num = (params.value as BigDecimal)
		if( num == null) {
			num = (random.nextInt(198) - 100)
		}
		def model = [
			num : num,
			className : "zero-block",
			code: "K"
		]
		if(num > 0) {
			model.className = "uparrow"
			model.code = "A"
		} else if( num < 0 ) {
			model.className = "downarrow"
			model.code = "A"
		}
		return model
	}
}
