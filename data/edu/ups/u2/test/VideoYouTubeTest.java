package edu.ups.u2.test;

import edu.ups.u2.VideoYouTube;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VideoYouTubeTest {

    @Test
    public void testLikes() {
        VideoYouTube v = new VideoYouTube("POO", 2024, "Educación", "Dev", "url");

        v.darLike();
        v.darLike();

        Assertions.assertEquals(2, v.getLikes());
    }
}
