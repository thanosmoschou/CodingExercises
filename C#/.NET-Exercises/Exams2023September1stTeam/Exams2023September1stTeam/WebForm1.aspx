<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="WebForm1.aspx.cs" Inherits="Exams2023September1stTeam.WebForm1" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <h1>Επίδειξη</h1>

            <br />
            <asp:Label ID="Label1" runat="server" Text="Γράψε έναν αριθμό: "></asp:Label>
&nbsp;
            <asp:TextBox ID="numInput" runat="server"></asp:TextBox>
            <br />
            <asp:Button ID="evenOrOddButton" runat="server" OnClick="evenOrOddButton_Click" Text="Even Or Odd" />
            <br />
            <br />
            <asp:Label ID="evenOrOddResult" runat="server"></asp:Label>
            <br />
            <br />
            <asp:DropDownList ID="countriesDropDown" runat="server" AutoPostBack="True" OnSelectedIndexChanged="countriesDropDown_SelectedIndexChanged">
            </asp:DropDownList>
            <br />
            <br />
            <asp:Label ID="Label2" runat="server" Text="ISO: "></asp:Label>
            <asp:Label ID="isoLabel" runat="server"></asp:Label>
            <br />
            <asp:Label ID="Label3" runat="server" Text="Capital: "></asp:Label>
            <asp:Label ID="capitalLabel" runat="server"></asp:Label>

        </div>
    </form>
</body>
</html>
