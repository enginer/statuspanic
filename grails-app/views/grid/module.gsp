<div>
    <table border='0' width='100%' cellpadding='0' cellspacing='10'>
	<g:each in="${model}" var="row" status="count">
        <tr${count %2 == 1 ? 'class="alt"' : ''}>
        <g:each in="${row}" var="col" status="j">
            <g:if test="${j !=3 }">
                <td class='cell_${j}'>${col}</td>
            </g:if>
            <g:else>
                <td class='cell_${j}'>
                <g:each in="${col.split(',')}" var="email">
                	<img src="http://www.gravatar.com/avatar/${email.trim().encodeAsMD5()}?s=40&d=wavatar">
                </g:each>
                </td>
            </g:else>
		</g:each>
        </tr>
    </g:each>
    </table>
</div>