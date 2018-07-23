import React from 'react';
import { Provider } from 'react-redux';
import { StyleSheet } from 'react-native';

import AppNavigator from './Routes';

import store from './store';

export default class App extends React.Component {
    render() {
        return (
            <Provider store={store}>
                <AppNavigator style={styles.container} />
            </Provider>
        );
    }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: 'powderblue',
    alignItems: 'center',
    justifyContent: 'center',
  },
});