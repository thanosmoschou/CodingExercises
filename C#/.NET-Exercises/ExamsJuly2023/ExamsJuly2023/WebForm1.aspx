<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="WebForm1.aspx.cs" Inherits="ExamsJuly2023.WebForm1" %>

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
            <asp:Label ID="Label1" runat="server" Text="Πρώτος Αριθμός"></asp:Label>
&nbsp;<asp:TextBox ID="firstNumInput" runat="server"></asp:TextBox>
            <br />
            <asp:Label ID="Label2" runat="server" Text="Δεύτερος Αριθμός"></asp:Label>
&nbsp;<asp:TextBox ID="secondNumInput" runat="server"></asp:TextBox>
            <br />
            <br />
            <asp:Label ID="Label3" runat="server" Text="Πηλίκο:"></asp:Label>
&nbsp;
            <asp:Label ID="quotLabel" runat="server"></asp:Label>
            <br />
            <asp:Label ID="Label4" runat="server" Text="Υπόλοιπο: "></asp:Label>
&nbsp;<asp:Label ID="remLabel" runat="server"></asp:Label>
            <br />
            <br />
            <asp:Button ID="checkButton" runat="server" OnClick="checkButton_Click" Text="Check" />
            <br />
            <br />
            <br />
            <asp:Label ID="Label5" runat="server" Text="Γράψε κάτι: "></asp:Label>
&nbsp;<asp:TextBox ID="textInput" runat="server"></asp:TextBox>
            <br />
            <asp:Label ID="Label6" runat="server" Text="Το κείμενο ανάμεσα στους χαρακτήρες κενού διαστήματος είναι: "></asp:Label>
&nbsp;<asp:Label ID="textOutput" runat="server"></asp:Label>
            <br />
            <asp:Button ID="separateButton" runat="server" OnClick="separateButton_Click" Text="Separate" />

        </div>
    </form>
</body>
</html>
