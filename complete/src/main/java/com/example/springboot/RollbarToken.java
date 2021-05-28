package com.example.springboot;

import static com.rollbar.notifier.config.ConfigBuilder.withAccessToken;
import com.rollbar.notifier.Rollbar;

public class RollbarToken {
	private static Rollbar rollbar = Rollbar.init(withAccessToken("405520644d774454bd0dd62ad0c67304").build());

    private RollbarToken() {}

    public static Rollbar getInstance() {
        return RollbarToken.rollbar;
    }
    
}