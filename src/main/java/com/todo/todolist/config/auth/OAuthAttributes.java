//package com.todo.todolist.config.auth;
//
//import com.todo.todolist.domain.user.Role;
//import com.todo.todolist.entity.Members;
//import lombok.Builder;
//import lombok.Getter;
//
//import java.util.Map;
//
//@Getter
//public class OAuthAttributes {
//    private Map<String, Object> attributes;
//    private String nameAttributeKey;
//    private String name;
//    private String email;
//    private String picture;
//
//    @Builder
//    public OAuthAttributes(Map<String, Object> attributes, String nameAttributeKey, String name, String email, String picture) {
//        this.attributes = attributes;
//        this.nameAttributeKey = nameAttributeKey;
//        this.name = name;
//        this.email = email;
//        this.picture = picture;
//    }
//
//    /**
//     * OAuth2User에서 반환하는 사용자 정보는 Map이기 때문에 값 하나하나를 반환해야 한다.
//     */
//    public static OAuthAttributes of(String registrationId, String userNameAttributeName, Map<String, Object> attributes) {
//        return ofGoogle(userNameAttributeName, attributes);
//    }
//
//    private static OAuthAttributes ofGoogle(String userNameAttributeName, Map<String, Object> attributes) {
//        return OAuthAttributes.builder()
//                .name((String) attributes.get("name"))
//                .email((String) attributes.get("email"))
//                .picture((String) attributes.get("picture"))
//                .attributes(attributes)
//                .nameAttributeKey(userNameAttributeName)
//                .build();
//    }
//
//    /**
//     * 가입할 때 기본 권한으로 USER를 부여
//     */
//    public Members toEntity() {
//        return Members.builder()
//                .name(name)
//                .email(email)
//                .picture(picture)
//                .role(Role.USER)
//                .secession(true)
//                .build();
//    }
//}
