<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="WebForm1.aspx.cs" Inherits="StadiumInfoLab2b.WebForm1" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <h1>Get information about a stadium</h1>

        </div>
        <asp:Label ID="Label1" runat="server" Text="Choose stadium:"></asp:Label>
&nbsp;<asp:DropDownList ID="DropDownList1" runat="server" AutoPostBack="True" OnSelectedIndexChanged="DropDownList1_SelectedIndexChanged">
        </asp:DropDownList>
        <br />
        <asp:Label ID="Label2" runat="server" Text="Stadium Name:"></asp:Label>
&nbsp;<asp:Label ID="stadiumNameLabel" runat="server"></asp:Label>
        <br />
        <asp:Label ID="Label4" runat="server" Text="Capacity: "></asp:Label>
&nbsp;<asp:Label ID="capacityLabel" runat="server"></asp:Label>
        <br />
        <asp:Label ID="Label5" runat="server" Text="City: "></asp:Label>
&nbsp;<asp:Label ID="cityLabel" runat="server"></asp:Label>
        <br />
        <asp:HyperLink ID="google" runat="server" Target="_blank">Google Url Link</asp:HyperLink>
        <br />
        <asp:HyperLink ID="wikipedia" runat="server" Target="_blank">Wikipedia</asp:HyperLink>
        <br />
    </form>
</body>
</html>
