import { createBrowserRouter } from "react-router";
import AdminPage from "../pages/AdminPage";
import HomePage from "../pages/HomePage";

const routes = createBrowserRouter([
    {
        path: "/",
        element: <HomePage />
    },
    {
        path: "/admin",
        element: <AdminPage />
    }
]);

export default routes;