package statuspanic

class CountdownController {

    def module = { 
		def now = new Date().getTime() / 1000
		def stop = (params.stop as Long) ?: now
		
		def days = (stop - now) / (60*60*24)
		def result
		if(days > 0) {
			result = "${days as Integer} DAYS <span class='event'>${params.event}</span>"
		} else {
			result = "COUNTDOWN FINISHED"
		}
		return [
			result: result
		]
	}
}
