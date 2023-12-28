Feature: Login

  Scenario: verify user successful login
    Given user navigates to application
    When user enter username and password
    Then verify login successful


    List<List<String>> data=user.raw();
    data.get(0).get(0)

    List<Map<String,String>> map=tabel.asMaps(String.class,String.class)
    map.get(0)