import streamlit as st
import csv, os

def create_inquiry():
    with st.form("user_info_form"):
    # Add text input fields for name, city, and inquiry
        name = st.text_input("Enter your name:")
        age = st.number_input("Enter your age:", min_value=0, max_value=150, step=1)
        city = st.text_input("Enter your city:")
        inquiry = st.text_input("Enter your inquiry:")

        # Add a submit button to the form
        submit_button = st.form_submit_button(label='Ask :)')
        if submit_button:
            file_exists = os.path.isfile("enquiry.csv")

        # Open the file in append mode ('a+')
            with open("enquiry.csv", "a+", newline='') as file:

                writer = csv.writer(file)
                # Write the header row if the file is empty
                if not file_exists:
                    writer.writerow(['Name', 'Age', 'City', 'Inquiry'])
                # Write the data
                writer.writerow([name, age, city, inquiry])
            st.write("Inquiry submitted successfully!")
            prescribe(inquiry)

def prescribe(key):
    
    with open('prescribe.csv', 'r') as csv_file:
        # Create a CSV reader object
        csv_reader = csv.reader(csv_file,delimiter=',')
        # Iterate through each row in the CSV file
        for row in csv_reader:
            # Check if the search value matches the value in the first column (Column A)
            if row and row[0] == key:
                # If found, print the corresponding value in the second column (Column B)
                print(f"Corresponding value in Column B: {row[1]}")
                st.write(f"\nPrescription as Follows : {row[1]}")
                return  # Exit the function after finding the first occurrence

    # If the search value is not found
    print("Search Enquiry not found !!!")  

if __name__ == "__main__":
    
    st.title("Doctor Gulati's Clinic")
    create_inquiry()
