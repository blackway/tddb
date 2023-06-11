#9장 테스트 벙위와 종류

1.테스트 범위(아래는 범위에 따른 순서)
기능 테스트--------(ui, 자바, 디비) (사용자가 요구한 프로그램 테스트)
    통합 테스트----(자바, 디비) (개별 테스트에서 디비, 통신 상호 연동)
        단위 테스트(자바(프로그램)) (개별 프로그램, 콤포넌트 테스트)

- 테스트 관련 용어는 문맥이나 사용자에 따라 의미가 다를 때도 있다. 예를 들어 개발 완료 후에 진행하는 최종 테스트를 '통합 테스트'라고 부르기도 한다. 고객의 입장에서 요구한 기능을 올바르게 구현했는지 수행하는 테스트를 '인수 테스트'라고 부르는데 요건을 완료 했는지 정의하기 위해 작성한 테스트를 '인수 테스트'라 부르기도 한다.

1.1.기능테스트와 E2E테스트
-기능테스트는 사용자 입장에서는 시스템이 제공하는 기능이 올바르게 동작하는지 확인하는 테스트.
 그러나, 웹 브라우저나 모바일 앱부터 시작해서 데이터베이스나 외부 서비스에 이르기까지 모든 구성 요소를 논리적으로 완전히 하나의 기능으로 다룬다. 테스트의 끝에서 끝까지 올바른지 검사하기 때문에 E2E 테스트로도 볼수 있다. (QA 조직에서 주로 하는 테스트)

1.2.테스트 벙위에 따른 테스트 코드 개수와 시간
- E2E 테스트, 통합 테스트, 단위 테스트 등 이 있지만, 단위 테스트를 제외한 테스트는 상황에 따라 테스트가 어려울수 있다. 그래서 가능하면 상황에 따른 제약이 없는 단위 테스트를 상세히 E2E, 통합 테스트 상황이에 가까운 대역을 사용 하여 단위 테스트를 만들도록 노력 해야한다.


2.외부 연동이 필요한 테스트 예
- 일부 외부 대상은 어느 정보 수준에서 제어가 가능한다. 그중에서 지 장에서는 DB 연동과 HTTP연동을 위한 테스트 코드 작성 예를 살펴본다.

2.1.스프링 부트와 DB 통합 테스트
 - UserRegisterIntTestUsingSql, UserRegisterIntTest, MemberDaoIntTest 은 @SpringBootTest 룰 사용.
 - MemberDaoJdbcTest 클래스의 @JdbcTest 어노테이션 사용.
    `@JdbcTest
    Spring Data JDBC를 사용하지 않고 오직 DataSource를 필요로하는 테스트에서 사용
    @JdbcTest는 in-memory embedded database가 설정되어 테스트를 위한 JdbcTemplate을 생성
    일반적인 @ConfigurationProperties와 @Component 빈들은 스캔되지 않는다.
    기본적으로 JDBC 테스트는 각 테스트마다 Rollback
    실제 Database를 사용하고 싶지 않으면 @AutoConfigureTestDatabase를 사용
    @AutoConfigureTestDatabase 기본 설정은 Replace.ANY로 되어있다.
    각각의 설정을 보면
    ANY : 자동 구성 또는 수동 정의 여부에 관계없이 DataSource를 교체
    AUTO_CONFIGURED : 자동 설정된 경우에만 DataSource를 교체
    NONE : 기본 DataSource를 교체하지 않음
    즉, 우리가 application.yml에 설정을 해두어도 Replace.ANY설정에 의해 DataSource를 in-memory설정으로 변경해버리는 것이다.
    따라서 이를 막고 실제 DB환경에서 테스트하고자하면 @AutoConfigureTestDatabase를 추가해주고, replace속성으로 Replace.NONE을 전달하면 우리가 사용하고자 하는 DB가 사용이 될 것이다.
        `

2.2. WireMock을 이용한 REST 클라이언트 테스트 (CardNumberValidatorTest.java)
  - 통합 테스트하기 어려운 외부 서버를 테스트 하기 위함.
  - WireMOCK을 사용하면 올바른 응담이나 타임아웃과 같은 상황에 대해 CardNumberValidator를 테스트할 수 있다.
  - 일반적인 사용법.
    테스트 실행 전에 WireMockServer를 시작한다. 실제 HTTP 서버가 뜬다
    테스트에서 WireMockServer의 동작을 기술한다.
    HTTP 연동을 수행하는 테스트를 실행한다.
    테스트 실행 후에 WireMockServer를 중지 한다.

2.3. 스프링 부터의 내영 서버를 이용한 API 기능 테스트
  -모바일 앱 회원 가입 테스트 코드를 작성해서 검증 과정을 자동화 하여, 수동으로 테스트 하는 시간을 줄일 수 있다.
    테스트에서 웹 환경을 구동할 수 있는 기능을 제공한다.
  - TestRestTemplate은 스프링 부트가 테스트 목적으로 제공하는 것이로서 내장 서버에 연결 하는 RestTemplate 이다. 