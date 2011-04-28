package statuspanic

class BargraphController {

    def module = {
    	def max_bar_width = 300G 
		def default_padding = 12
		
		def bars = [
			['GREEN',  18,   1],
			['PINK',      29,   3],
			['BLUE',    48,   3],
			['SERVICE DESK',   8,   2],
			['CI',   23,   0],
			['SECRETS',   15,   2]
		]
		def total_outer = default_padding * 2
		def max_width = (params.width ?: 0) as BigDecimal
		def max_height = bars.max { it[1] }[1]
		def num_bars = bars.size()
		def bar_width = Math.floor(Math.min(max_bar_width, (max_width - (total_outer * num_bars)) / num_bars))
		def final_padding = Math.max(default_padding, (max_width - ((bar_width+total_outer) * num_bars)) / num_bars / 2 ) as Integer
		
		return [ 
			bars : bars.collect { bar ->
				def bar_height =  Math.floor((bar[1] / max_height) * (params.height as Integer)) as Integer
				
				return [
					top_offset : (params.height as Integer) - bar_height,
					height : bar[1],
					remaining : bar[2],
					bar_height : bar_height as Integer,
					name : bar[0]
				]
			},
			bar_width :  bar_width as Integer,
			final_padding : final_padding
		]
	}
}
