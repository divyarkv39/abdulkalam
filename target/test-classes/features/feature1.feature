Feature: Gmail mail compose

  Scenario Outline: 
    Given open "chrome" browser
    And launch site using "http://www.gmail.com"
    When do login using "rguktrkv7@gmail.com" and "Divya@123"
    Then compose is displayed
    When click on compose
    Then fields should be  displayed
    When fill fields with "<to>", "<subject>","<body>" and "<attachment>"
    Then send is enabled
    When click on send
    Then "message sent" should be displayed
    When do logout
    Then login page should be displayed
    When close site

    Examples: 
      | to                    | subject | body    | attachment                      |
      | divyadsp737@gmail.com | wishes  | hi      | C:\\Users\\user\\Desktop\\1.jpg |
      | rguktrkv7@gmail.com   | wishes  | hi papa | C:\\Users\\user\\Desktop\\1.jpg |
