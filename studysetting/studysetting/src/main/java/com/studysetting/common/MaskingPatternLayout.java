//package com.studysetting.common;
//
//import ch.qos.logback.classic.PatternLayout;
//import ch.qos.logback.classic.spi.ILoggingEvent;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//import java.util.stream.Collectors;
//import java.util.stream.IntStream;
//
//public class MaskingPatternLayout extends PatternLayout {
//    private Pattern multilinePattern;
//    private List<String> maskPatterns = new ArrayList<>();
//    public void addMaskPattern(String maskPattern) {
//        maskPatterns.add(maskPattern);
//        multilinePattern = Pattern.compile(maskPatterns.stream().collect(Collectors.joining(Collectors.joining("|")), Pattern.MULTILINE);
//    }
///*    maskPattern element 생성
//    maskPattern element의 정규식 값을 '|'로 구분하고 list에 추가*/
//
//    @Override
//    public String doLayout(ILoggingEvent event) {
//        return maskMessage(super.doLayout(event));
//    }
////    maskPattern element에 정의된 정규식과 실제 데이터를 비교하여 정규식과 일치하면 마스킹처리함
//    private String maskMessage(String message) {
//        if(multilinePattern == null) {
//            return message;
//        }
//        StringBuffer sb = new StringBuffer(message);
//        Matcher matcher = multilinePattern.matcher(sb);
//        while(matcher.find()) {
//            IntStream.rangeClosed(1, matcher.groupCount()).forEach(group -> {
//                if(matcher.group(group) !=null) {
//                    IntStream.range(matcher.start(group), matcher.end(group)).forEach(i -> sb.setCharAt(i, '*'));
//                }
//                //
//            });
//        }
//    }
//}
