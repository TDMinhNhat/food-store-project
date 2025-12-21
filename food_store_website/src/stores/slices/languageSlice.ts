import { createSlice, type PayloadAction } from "@reduxjs/toolkit";
import english from "../../assets/language/english.json";
import vietnamese from "../../assets/language/vietnamese.json";

export const languageSlice = createSlice({
    name: "language",
    initialState: english,
    reducers: {
        setLanguage: (_state, action: PayloadAction<typeof english>) => {
            switch(action.payload) {
                case "english":
                    return english;
                case "vietnamese":
                    return vietnamese;
                default:
                    return english;
            }
        }
    }
});

export const { setLanguage } = languageSlice.actions;
export default languageSlice.reducer;