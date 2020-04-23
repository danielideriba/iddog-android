package br.android.iddog

import br.android.iddog.utils.EmailValidator
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test


class EmailValidatorFieldTest {
    @Test
    fun emailValidator_CorrectEmailSimple_ReturnsTrue(): Unit {
        assertTrue(EmailValidator.isValidEmail("danielideriba@gmail.com"))
    }

    @Test
    fun emailValidator_CorrectEmailSimple_ReturnsFalse(): Unit {
        assertFalse(EmailValidator.isValidEmail("3333.com"))
    }
}