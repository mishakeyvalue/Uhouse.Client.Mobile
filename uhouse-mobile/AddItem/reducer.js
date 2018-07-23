import { ADD_ITEM } from './actions';

initialState = []

export default (state = initialState, action) => {
    switch (action.type) {
        case ADD_ITEM:
            return [...state, {id: action.date, date: action.date}];
        default: 
            return state;
    }
}