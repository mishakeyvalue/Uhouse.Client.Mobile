import { createDrawerNavigator } from "react-navigation";

import Home from "../Home";
import UriSettings from "../UriSettings"

export default createDrawerNavigator(
    {
        Home: { screen: Home },
        UriSettings: { screen: UriSettings}
    },
    {
        headerMode: 'none',
        initialRouteName: "UriSettings"
    }
);
