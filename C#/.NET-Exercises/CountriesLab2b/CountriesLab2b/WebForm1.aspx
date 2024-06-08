<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="WebForm1.aspx.cs" Inherits="CountriesLab2b.WebForm1" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <h1>Country Information</h1>
            <asp:Label ID="Label1" runat="server" Text="Country"></asp:Label>
        &nbsp;<asp:DropDownList ID="lstCountry" runat="server" OnSelectedIndexChanged="lstCountry_SelectedIndexChanged" AutoPostBack="True">
            </asp:DropDownList>
            <br />
            <asp:Label ID="Label2" runat="server" Text="Iso Code: "></asp:Label>
            <asp:Label ID="lblIsoCode" runat="server"></asp:Label>
            <br />
            <asp:Label ID="Label3" runat="server" Text="Capital: "></asp:Label>
            <asp:Label ID="lblCapital" runat="server"></asp:Label>
            <br />
            <asp:Image ID="Image1" runat="server" />
            <br />
            <asp:Label ID="Label4" runat="server" Text="International Calling Code: "></asp:Label>
            <asp:Label ID="lblPhone" runat="server"></asp:Label>
            <br />
            <asp:Label ID="lblCurrency" runat="server"></asp:Label>
            <br />
            <asp:Button ID="btnCountry" runat="server" Text="Invoke" OnClick="btnCountry_Click" />
        </div>
    </form>
</body>
</html>
