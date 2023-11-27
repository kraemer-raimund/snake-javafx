package dev.raimundkraemer.snake;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FailingTest {

    @Test
    void fails() {
        assertThat(false).isTrue();
    }
}
