package statuspanic

class ClockController {

    def module = {
		def time = Calendar.getInstance()
		if(params.timezone) {
			def tz = TimeZone.getTimeZone(params.timezone)
			time = Calendar.getInstance( tz )
		}
		def format = params.format ?: "h:m a"

		return [
			time : time.format(format)
		]
	}
}
