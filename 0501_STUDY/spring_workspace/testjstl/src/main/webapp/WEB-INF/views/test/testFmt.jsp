<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>testFmt</title>
</head>
<body>
<h1>jstl 포매팅 라이브러리 테스트</h1>
<hr>
testCore.jsp 에서 만든 sum 변수값 (scope="session") : ${ sum }
<br>
<hr>

<h4>fmt:formatDate 태그 : 날짜와 시간에 포맷 적용해서 출력하는 태그임</h4>
value 속성에는 java.util.Date 객체를 사용해야 함<br>
출력확인 - 오늘 날짜 : <fmt:formatDate value="<%= new java.util.Date() %>"/> <br>
<c:set var="today" value="<%= new java.util.Date() %>"/> <br>
현재 시간 : <fmt:formatDate value="${today}" type="time"/>
<hr>

<h4>제공된 날짜와 시간 스타일 사용</h4>
[short] : <fmt:formatDate value="${today}" type="both" dateStyle="short" timeStyle="short"/> <br>
[medium] : <fmt:formatDate value="${today}" type="both" dateStyle="medium" timeStyle="medium"/> <br>
[long] : <fmt:formatDate value="${today}" type="both" dateStyle="long" timeStyle="long"/> <br>
[full] : <fmt:formatDate value="${today}" type="both" dateStyle="full" timeStyle="full"/> <br>
<hr>

<h3>pattern 속성으로 원하는 대로 포메팅 지정할 수도 있음</h3>
현재 날짜 : <fmt:formatDate value="${today }" type="date" pattern="yyyy/MM/dd (E)"/><br>
현지 시간 : <fmt:formatDate value="${today }" type="time" pattern="(a) hh:mm:ss초"/><br>
<hr>

<h4>fmt:setLocale 태그 : 지역대 설정하는 태그임</h4>
<fmt:setLocale value="ko_kr"/>

<h4>fmt:timeZone 태그 : 시간대 설정하는 태그임, fmt:setTimeZone 태그 사용해도 됨</h4>
한국 현재 시간 : <fmt:formatDate value="${today }" type="both"/><br>
뉴욕 현재 시간 : <fmt:timeZone value="America/New_York">
<fmt:formatDate value="<%= new java.util.Date() %>" type="both"/>
</fmt:timeZone>
<br>
런던 현재 시간 : <fmt:timeZone value="Europe/London">
<fmt:formatDate value="<%= new java.util.Date() %>" type="both"/>
</fmt:timeZone>
<br>
<hr>

<h4>fmt:formatNumber 태그 : 숫자데이터 포맷 지정 태그임</h4>
숫자 그대로 출력 :
<fmt:formatNumber value="123456789" groupingUsed="false"/> <br>
천단위 구분기호 적용 :
<fmt:formatNumber value="123456789" groupingUsed="true"/> <br>
실수값 소숫점 아래 자릿수 지정 출력 : pattern 속성 사용함 (#, 0 사용함)
# 을 사용한 경우 : 지정한 자리에 값이 없으며 표기되지 않는다.
<fmt:formatNumber value="1.234567" pattern="#.##"/><br>
<fmt:formatNumber value="1.2" pattern="#.##"/><br>
0 을 사용한 경우 : 지정한 자리에 값이 없으면 0표시함 <br>
<fmt:formatNumber value="1.2" pattern="#.00"/>

<h4>type 속성으로 백분율, 통화기호 표시 처리함</h4>
<fmt:formatNumber value="0.12" type="percent"/><br>
<fmt:formatNumber value="123456789" type="currency"/><br>
<fmt:formatNumber value="123456789" type="currency" currencySymbol="$"/><br>

</body>
</html>