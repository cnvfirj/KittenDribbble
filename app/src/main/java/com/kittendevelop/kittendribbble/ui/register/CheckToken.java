package com.kittendevelop.kittendribbble.ui.register;

import com.kittendevelop.kittendribbble.ui.help.ShowWaiting;

public interface CheckToken extends ShowWaiting {
    void gettingToken(String token);
    void followingLink(String link);
    void startActivity();
}
