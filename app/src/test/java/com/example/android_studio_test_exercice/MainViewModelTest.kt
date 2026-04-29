package com.example.android_studio_test_exercice

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.compose.ui.state.ToggleableState
import com.example.android_studio_test_exercice.viewmodel.MainViewModel
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Rule
import org.junit.Test

class MainViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val viewModel = MainViewModel()

    @Test
    fun testToggleEstatSwitch() {
        val initialValue = viewModel.estatSwitch.value
        viewModel.toggleEstatSwitch()
        assertNotEquals(initialValue, viewModel.estatSwitch.value)
    }

    @Test
    fun testToggleEsVegetaria() {
        val initialValue = viewModel.esVegetaria.value
        viewModel.toggleEsVegetaria()
        assertNotEquals(initialValue, viewModel.esVegetaria.value)
    }

    @Test
    fun testToggleEsVega() {
        val initialValue = viewModel.esVega.value
        viewModel.toggleEsVega()
        assertNotEquals(initialValue, viewModel.esVega.value)
    }

    @Test
    fun testToggleEsCarnivor() {
        val initialValue = viewModel.esCarnivor.value
        viewModel.toggleEsCarnivor()
        assertNotEquals(initialValue, viewModel.esCarnivor.value)
    }

    @Test
    fun testToggleTriStateStatus() {
        viewModel.toggleTriStateStatus()
        assertEquals(ToggleableState.Indeterminate, viewModel.triStateStatus.value)
    }

    @Test
    fun testSetSelectedOption() {
        val newOption = "Lamine Yamal"
        viewModel.setSelectedOption(newOption)
        assertEquals(newOption, viewModel.selectedOption.value)
    }

    @Test
    fun testSetSliderValue() {
        val newValue = 50f
        viewModel.setSliderValue(newValue)
        assertEquals(newValue, viewModel.sliderValue.value)
    }

    @Test
    fun testSetSearchText() {
        val newText = "Test"
        viewModel.setSearchText(newText)
        assertEquals(newText, viewModel.searchText.value)
    }

    @Test
    fun testPerformSearch() {
        viewModel.performSearch()
        assertEquals(true, viewModel.showSnackbar.value)
    }

    @Test
    fun testToggle() {
        val initialValue = viewModel.toggleState.value
        viewModel.toggle()
        assertNotEquals(initialValue, viewModel.toggleState.value)
    }
}