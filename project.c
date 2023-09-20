#include <stdio.h>

// for length
float convertLength(float value, int fromUnit, int toUnit)
{
    // 1 - meters, 2 - feet, 3-centimeter

    if (fromUnit == 1 && toUnit == 2)
    {
        return value * 3.281;
    }
    else if (fromUnit == 2 && toUnit == 1)
    {
        return value / 3.281;
    }
    else if (fromUnit == 1 && toUnit == 3)
    {
        return value * 100;
    }
    else if (fromUnit == 3 && toUnit == 1)
    {
        return value / 100;
    }
    else if (fromUnit == 2 && toUnit == 3)
    {
        return value * 30.48;
    }
    else if (fromUnit == 3 && toUnit == 2)
    {
        return value * 0.0328084;
    }
    return value;
}
// for temperature
float convertTemperature(float value, int fromUnit, int toUnit)
{
    // Implement your conversion logic here
    // 1 - Celsius, 2 - Fahrenheit, 3 - kelvin
    if (fromUnit == 1 && toUnit == 2)
    {
        return (value * 9 / 5) + 32;
    }
    else if (fromUnit == 2 && toUnit == 1)
    {
        return (value - 32) * 5 / 9;
    }
    else if (fromUnit == 1 && toUnit == 3)
    {
        return value + 273.15;
    }
    else if (fromUnit == 3 && toUnit == 1)
    {
        return value - 273.15;
    }
    else if (fromUnit == 3 && toUnit == 2)
    {
        return (value * 9 / 5) - 459.67;
    }
    else if (fromUnit == 2 && toUnit == 3)
    {
        return (value + 459.67) * 5 / 9;
    }
    else
    {
        return ('Enter The Correct Value');
    }

    return value;
}
// for area
float convertArea(float value, int fromUnit, int toUnit)
{
    // Conversion formulas:
    // 1 - square meters, 2 - square feet, 3 - acres
    if (fromUnit == 1 && toUnit == 2)
    {
        return value * 10.764;
    }
    else if (fromUnit == 2 && toUnit == 1)
    {
        return value / 10.764;
    }
    else if (fromUnit == 2 && toUnit == 3)
    {
        return value * 0.0000229568;
    }
    else if (fromUnit == 3 && toUnit == 2)
    {
        return value * 43560;
    }
    else if (fromUnit == 1 && toUnit == 3)
    {
        return value * 0.000247105;
    }
    else if (fromUnit == 3 && toUnit == 1)
    {
        return value / 0.000247105;
    }
    else
    {
        return ('Enter The Correct Value');
    }
    return value;
}
// for pressure
float convertPressure(float value, int fromUnit, int toUnit)
{
    // Conversion formulas:
    // 1 - kilopascals, 2 - pounds per square inch (psi), 3 - atmospheres
    if (fromUnit == 1 && toUnit == 2)
    {
        return value * 0.145038;
    }
    else if (fromUnit == 2 && toUnit == 1)
    {
        return value / 0.145038;
    }
    else if (fromUnit == 1 && toUnit == 3)
    {
        return value * 0.00986923;
    }
    else if (fromUnit == 3 && toUnit == 1)
    {
        return value / 0.00986923;
    }
    else
    {
        return ('Enter The Correct Value');
    }
    return value;
}
// for weight
float convertWeight(float value, int fromUnit, int toUnit)
{
    // Conversion formulas:
    // 1 - kilograms, 2 - pounds, 3 - grams
    if (fromUnit == 1 && toUnit == 2)
    {
        return value * 2.20462;
    }
    else if (fromUnit == 2 && toUnit == 1)
    {
        return value / 2.20462;
    }
    else if (fromUnit == 1 && toUnit == 3)
    {
        return value * 1000;
    }
    else if (fromUnit == 3 && toUnit == 1)
    {
        return value / 1000;
    }
    else
    {
        return ('Enter The Correct Value');
    }
    return value;
}
float convertspeed(float value, int fromUnit, int toUnit)
{
    // 1 - km/hr , 2 - miles/hr
    if (fromUnit == 1 && toUnit == 2)
    {
        return value * 0.621371;
    }
    else if (fromUnit == 2 && toUnit == 1)
    {
        return value * 1.60934;
    }
    else
    {
        return ('Enter The Correct Value');
    }
    return value;
}

int main()
{
    int choice;
    do
    {
        printf("\nSelect Conversion Type:\n");
        printf("\t---------------------------\n");
        printf("1. Length\n");
        printf("\t---------------------------\n");
        printf("2. Area\n");
        printf("\t---------------------------\n");
        printf("3. Weight\n");
        printf("\t---------------------------\n");
        printf("4. Temperature\n");
        printf("\t---------------------------\n");
        printf("5. Speed\n");
        printf("\t---------------------------\n");
        printf("6. Exit\n");
        printf("\n---------------------------\n");

        printf("Enter Your Choice For Conversation => ");
        scanf("%d", &choice);

        if (choice == 1)
        {
            // lenght logic
            float value;
            int fromUnit, toUnit;

            printf("Enter value: ");
            scanf("%f", &value);

            printf("Enter source unit (1 - meters, 2 - feet, 3-centimeter): ");
            scanf("%d", &fromUnit);

            printf("Enter target unit (1 - meters, 2 - feet, 3-centimeter): ");
            scanf("%d", &toUnit);

            float result = convertLength(value, fromUnit, toUnit);
            printf("Converted value: %.2f\n", result);
        }
        else if (choice == 2)
        {
            // area logic
            float value;
            int fromUnit, toUnit;

            printf("Enter value: ");
            scanf("%f", &value);

            printf("Enter source unit (1 - sq. meters, 2 - sq. feet, 3 - acres): ");
            scanf("%d", &fromUnit);

            printf("Enter target unit (1 - sq. meters, 2 - sq. feet, 3 - acres): ");
            scanf("%d", &toUnit);

            float result = convertArea(value, fromUnit, toUnit);
            printf("Converted value: %.2f\n", result);
        }
        else if (choice == 3)
        {
            // weight logic
            float value;
            int fromUnit, toUnit;

            printf("Enter value: ");
            scanf("%f", &value);

            printf("Enter source unit (1 - kilograms, 2 - pounds, 3 - grams): ");
            scanf("%d", &fromUnit);

            printf("Enter target unit (1 - kilograms, 2 - pounds, 3 - grams): ");
            scanf("%d", &toUnit);

            float result = convertWeight(value, fromUnit, toUnit);
            printf("Converted value: %.2f\n", result);
        }
        else if (choice == 4)
        {
            // tempreture logic
            float value;
            char fromUnit, toUnit;

            printf("Enter value: ");
            scanf("%f", &value);

            printf("Enter source unit (1 - Celsius, 2 - Fahrenheit, 3 - kelvin): ");
            scanf(" %c", &fromUnit);

            printf("Enter target unit (1 - Celsius, 2 - Fahrenheit, 3 - kelvin): ");
            scanf(" %c", &toUnit);

            float result = convertTemperature(value, fromUnit, toUnit);
            printf("Converted value: %.2f\n", result);
        }
        else if (choice == 5)
        {

            float value;
            int fromUnit, toUnit;

            printf("Enter value: ");
            scanf("%f", &value);

            printf("Enter source unit (1 - km/hr , 2 - miles/hr): ");
            scanf("%d", &fromUnit);

            printf("Enter target unit (1 - km/hr , 2 - miles/hr): ");
            scanf("%d", &toUnit);

            float result = convertspeed(value, fromUnit, toUnit);
            printf("Converted value: %.2f\n", result);
        }
        else if (choice == 6)
        {
            printf("Exiting the program. Goodbye!\n");
            break; // Exit the loop
        }
        else
        {
            printf("Invalid choice.\n");
        }
    } while (1); // Infinite loop

    return 0;
}