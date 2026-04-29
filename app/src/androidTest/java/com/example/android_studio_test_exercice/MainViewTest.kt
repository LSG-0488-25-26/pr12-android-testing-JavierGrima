package com.example.android_studio_test_exercice

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performSemanticsAction
import androidx.compose.ui.semantics.SemanticsActions
import androidx.compose.ui.test.hasProgressBarRangeInfo
import com.example.android_studio_test_exercice.view.MainView
import com.example.android_studio_test_exercice.viewmodel.MainViewModel
import org.junit.Rule
import org.junit.Test

class MainViewTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testMainViewFullCoverage() {
        composeTestRule.setContent {
            MainView(myViewModel = MainViewModel())
        }

        // Switch
        composeTestRule.onNodeWithText("Activar Wi-Fi: ").performClick()

        // Checkbox
        composeTestRule.onNodeWithText("Vegetarià/na").performClick()
        composeTestRule.onNodeWithText("Vegà/na").performClick()

        // Tristate
        composeTestRule.onNodeWithText("TriState").performClick()

        // Opciones jugadores
        composeTestRule.onNodeWithText("Lamine Yamal").performClick()

        // Slider
        composeTestRule.onNode(hasProgressBarRangeInfo(androidx.compose.ui.semantics.ProgressBarRangeInfo(0f, 0f..100f, 0)))
            .performSemanticsAction(SemanticsActions.SetProgress) { it(50f) }

        // Opciones desplegable
        composeTestRule.onNodeWithText("Opció A").performClick()
        composeTestRule.onNodeWithText("Opció B").performClick()

        // Buscador
        composeTestRule.onNodeWithText("Buscar...").performTextInput("Test final")
        composeTestRule.onNodeWithText("Buscar").performClick()

        // Boton deactivado/activado
        composeTestRule.onNodeWithText("Desactivat").performClick()
        composeTestRule.onNodeWithText("Activat").assertExists()
        composeTestRule.onNodeWithText("Acció completada!").assertExists()
    }
}