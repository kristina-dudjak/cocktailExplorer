# cocktailExplorer
Cocktails app which uses TheCocktailDB API to display cocktails which you can add to favourites and add their ingredients to a shopping cart.

## Testing the app

UI tests are written with **Espresso** testing framework which allows automation tests. Espresso can be easily set up by importing appropriate dependencies in the build gradle file.

### Tests structure

The application consists of three main fragments: CocktailsFragment, FavouritesFragment and ShoppingListFragment. Each fragment has its representative test class:
 1. **CocktailsFragmentTest**
    - findExactCocktail() - checks if there exists a cocktail with exact name
    - matchesCocktailName() - checks if the name of the provided cocktail is the same as the cocktail name in details page
 2. **FavouritesFragmentTest**
    - addToFavourites() - checks if the cocktail is added to favourites page
    - removeFromFavourites() - checks if the cocktail is removed from favourites page
 3. **ShoppingFragmentTest**
    - addToShoppingList() - checks if all the ingredients are added to shopping list page
    - removeFromShoppingList() - checks if ingredient is removed from the shopping list page

Each of the tests extend the **BaseTest** class which defines the ActivityScenarioRule that launches the MainActivity before the tests start. 

The tests are wrapped by **page objects** that allow clean code and reusability. 

### Report

Generating the test reports is done by using [Spoon by Jake Wharton](https://github.com/square/spoon).

### Setup
Test can be run from the path app/build/src/androidTest, right click on the folder and select Run tests  
For running the tests with a report, in the terminal the following command needs to be written: gradlew spoonDebugAndroidTest (Ctrl + Enter)

